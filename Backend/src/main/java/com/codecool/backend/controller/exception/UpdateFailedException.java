package com.codecool.backend.controller.exception;

public class UpdateFailedException extends RuntimeException {
    public UpdateFailedException() {
        super("Failed to update user");
    }
}
