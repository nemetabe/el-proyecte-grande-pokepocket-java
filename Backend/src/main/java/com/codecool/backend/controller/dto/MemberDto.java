package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;

import java.util.List;

public record MemberDto(int id, String name, String email, List<Transaction> transactions) {
    public MemberDto(Member member) {
        this(member.getId(), member.getName(), member.getEmail(), member.getTransactions());
    }
}
