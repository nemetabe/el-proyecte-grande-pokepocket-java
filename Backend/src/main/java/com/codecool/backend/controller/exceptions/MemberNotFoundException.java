package com.codecool.backend.controller.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException() {
        super("User not Found");
    }
}
