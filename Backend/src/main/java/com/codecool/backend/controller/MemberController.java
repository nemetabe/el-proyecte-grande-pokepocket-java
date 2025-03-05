package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MemberCredentialsDto;
import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;
import com.codecool.backend.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class MemberController {

    private MemberService userService;

    public MemberController(MemberService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    int logIn(@RequestBody MemberCredentialsDto userCredentials) {
        return userService.logIn(userCredentials);
    }

    @PostMapping("/register")
    int signUp(@RequestBody MemberRegistrationDto userRegistration) {
        return userService.signUp(userRegistration);
    }

    @GetMapping("/{id}")
    MemberDto getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("")
    boolean updateUser(@RequestBody MemberDto userDto) {
        return userService.updateUser(userDto);
    }
}
