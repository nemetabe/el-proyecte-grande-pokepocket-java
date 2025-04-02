package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.*;
import com.codecool.backend.model.Member;
import com.codecool.backend.security.jwt.JwtUtils;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class MemberController {

    private final MemberService userService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public MemberController(MemberService userService, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userService = userService;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberCredentialsDto loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .toList();
        Member loggedMember = userService.findMemberByEmail(userDetails.getUsername());
        return ResponseEntity
                .ok(new JwtResponse(jwt, loggedMember.getName(), roles));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody MemberRegistrationDto signUpRequest) {
        return userService.register(signUpRequest, encoder);
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public MemberProfileDto getProfile() {
        // Get current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Get the member associated with the email
        Member currentMember = userService.findMemberByEmail(currentUserEmail);

        return new MemberProfileDto(currentMember.getId(), currentMember.getName(), currentMember.getEmail(), currentMember.getTargetAmount());
    }

    @GetMapping("/{id}")
    public MemberDto getUser(@PathVariable int id) {
        return userService.getMember(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteMember(id);
    }


    @PutMapping("/profile/update")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> updateUser(@RequestBody UpdateProfileDto profileDto) {
        // Get current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        // Get the member associated with the email
        Member currentMember = userService.findMemberByEmail(currentUserEmail);

        if (currentMember.getPassword() != encoder.encode(profileDto.currentPassword())) {
            return ResponseEntity.badRequest().body("Wrong current password");
        }

        currentMember.setName(profileDto.username());
        currentMember.setPassword(encoder.encode(profileDto.newPassword()));
        currentMember.setTargetAmount(profileDto.newTargetAmount());

        boolean updated = userService.updateUser(currentMember);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Failed to update user");
        }
    }
}
