package com.codecool.backend.controller.dto;

import com.codecool.backend.dao.model.User;

public record UserDto(int id, String name, String email) {
    public UserDto(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
