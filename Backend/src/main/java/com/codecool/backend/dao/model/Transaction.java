package com.codecool.backend.dao.model;

public record Transaction(int id, String name, int categoryId, int amount) {
}
