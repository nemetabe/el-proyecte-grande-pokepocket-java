package com.codecool.backend.controller.dto;

import com.codecool.backend.dao.model.Member;

public record MemberDto(int id, String name, String email) {
    public MemberDto(Member user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
