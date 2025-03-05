package com.codecool.backend.dao.model;

import com.codecool.backend.controller.dto.UserDto;
import com.codecool.backend.controller.dto.UserRegistrationDto;

public class User {
    private int id;
    private String name;

    private String email;
    private String password;

    public User(String name) {
        this.name = name;
    }

    public User(UserRegistrationDto userRegistrationDto) {
        name = userRegistrationDto.name();
        email = userRegistrationDto.email();
        password = userRegistrationDto.password();
    }

    public User(UserDto userDto) {
        id = userDto.id();
        name = userDto.name();
        email = userDto.email();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}



