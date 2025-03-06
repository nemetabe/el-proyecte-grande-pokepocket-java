package com.codecool.backend.controller.dto;

public record NewTransactionDto(String name, int categoryId, int amount) {
}
