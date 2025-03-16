package com.codecool.backend.controller.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException() {
        super("User not Found");
    }
}
