package com.codecool.backend.dao.model;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;

public class Transaction {
    int id;
    String name;
    int categoryId;
    int amount;

    public Transaction(int id, String name, int categoryId, int amount) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.amount = amount;
    }

    public Transaction(TransactionDto dto) {
        id = dto.id();
        name = dto.name();
    }

    public Transaction(NewTransactionDto dto) {
        name = dto.name();
        amount = dto.amount();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }
    public int getAmount() {
        return amount;
    }
}
