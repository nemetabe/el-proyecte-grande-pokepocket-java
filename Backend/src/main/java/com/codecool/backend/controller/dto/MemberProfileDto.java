package com.codecool.backend.controller.dto;

import java.math.BigDecimal;

public record MemberProfileDto(int id, String username, String email, BigDecimal targetAmount) {
}
