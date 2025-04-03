package com.codecool.backend.controller.dto;

import java.util.List;

public record EvolutionDto(int evolutionState, List<String> evolutionPictures, List<String> evolutionGifs, List<String> evolutionNames) {
}
