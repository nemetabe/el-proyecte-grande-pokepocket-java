package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Category;
import com.codecool.backend.model.Member;
import com.codecool.backend.model.Transaction;

import java.time.LocalDate;

public record TransactionDto(Long id, String name, Category category, int amount, int memberId, LocalDate date) {
    public TransactionDto(Transaction transaction){
        this(transaction.getId(), transaction.getName(), transaction.getCategory(), transaction.getAmount(), transaction.getMember().getId(), transaction.getDate());
    }
}
