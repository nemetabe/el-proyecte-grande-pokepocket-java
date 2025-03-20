package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Member;

public record NewTransactionDto(String name, int categoryId, int amount, int memberId) {
}
