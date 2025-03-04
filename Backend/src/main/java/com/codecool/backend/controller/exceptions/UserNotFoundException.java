package com.codecool.backend.controller.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User not Found");
    }
}
