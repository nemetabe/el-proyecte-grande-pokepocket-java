package com.codecool.backend.dao.model;

import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;

public class Member {
    private int id;
    private String name;
    private String email;
    private String password;

    public Member(String name) {
        this.name = name;
    }

    public Member(MemberRegistrationDto userRegistrationDto) {
        name = userRegistrationDto.name();
        email = userRegistrationDto.email();
        password = userRegistrationDto.password();
    }

    public Member(MemberDto userDto) {
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



