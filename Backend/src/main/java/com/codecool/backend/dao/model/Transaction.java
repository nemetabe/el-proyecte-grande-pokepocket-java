package com.codecool.backend.dao.model;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;

import java.util.Objects;

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
        categoryId = dto.categoryId();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && categoryId == that.categoryId && amount == that.amount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryId, amount);
    }
}
