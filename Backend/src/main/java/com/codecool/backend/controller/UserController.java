package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.UserCredentialsDto;
import com.codecool.backend.controller.dto.UserDto;
import com.codecool.backend.controller.dto.UserRegistrationDto;
import com.codecool.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    int logIn(@RequestBody UserCredentialsDto userCredentials) {
        return userService.logIn(userCredentials);
    }

    @PostMapping("/register")
    int signUp(@RequestBody UserRegistrationDto userRegistration) {
        return userService.signUp(userRegistration);
    }

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("")
    boolean updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }
}
