package com.codecool.backend.model;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Entity
public class Transaction {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int categoryId;
    private int amount;

    public Transaction() {
    }

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
