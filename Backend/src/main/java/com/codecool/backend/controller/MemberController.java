package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MemberCredentialsDto;
import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class MemberController {

    private final MemberService userService;

    @Autowired
    public MemberController(MemberService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public int logIn(@RequestBody MemberCredentialsDto userCredentials) {
        return userService.logIn(userCredentials);
    }

    @PostMapping("/register")
    public int signUp(@RequestBody MemberRegistrationDto userRegistration) {
        return userService.signUp(userRegistration);
    }

    @GetMapping("/{id}")
    public MemberDto getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("")
    public boolean updateUser(@RequestBody MemberDto userDto) {
        return userService.updateUser(userDto);
    }
}
