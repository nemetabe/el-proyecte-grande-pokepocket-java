package com.codecool.backend.controller.exception;

public class WrongPassword extends RuntimeException {
    public WrongPassword() {
        super("Wrong current password");
    }
}
