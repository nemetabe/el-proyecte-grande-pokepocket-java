package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Category;
import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;

public record TransactionDto(Long id, String name, Category category, int amount, Member member) {
    public TransactionDto(Transaction transaction){
        this(transaction.getId(), transaction.getName(), transaction.getCategory(), transaction.getAmount(), transaction.getMember());

    }
}
