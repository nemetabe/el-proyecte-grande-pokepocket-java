package com.codecool.backend.controller.dto;

import com.codecool.backend.dao.model.Transaction;

public record TransactionDto(int id, String name, int category, int amount) {
    public TransactionDto(Transaction transaction){
        this(transaction.getId(), transaction.getName(), transaction.getCategoryId(), transaction.getAmount());
    }
}
