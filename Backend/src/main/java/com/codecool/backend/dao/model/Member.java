package com.codecool.backend.dao.model;

import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.MemberRegistrationDto;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id
                && Objects.equals(name, member.name)
                && Objects.equals(email, member.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

}



