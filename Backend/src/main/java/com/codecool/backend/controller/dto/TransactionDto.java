package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;

public record TransactionDto(Long id, String name, int category, int amount, Member member) {
    public TransactionDto(Transaction transaction){
        this(transaction.getId(), transaction.getName(), transaction.getCategoryId(), transaction.getAmount(), transaction.getMember());
    }
}
