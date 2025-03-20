package com.codecool.backend.controller.dto;

import com.codecool.backend.model.Member;

public record NewTransactionDto(String name, Long categoryId, int amount, int memberId) {
}
