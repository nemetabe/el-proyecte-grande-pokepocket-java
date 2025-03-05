package com.codecool.backend.dao.model;

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

    public int getId() {
        return id;
    }

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
