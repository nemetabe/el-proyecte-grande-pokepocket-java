package com.codecool.backend.controller.dto.pokemon;

import java.util.List;

public record EvolutionStageDto(List<EvolutionStageDto> evolvesTo, NamedPokeApiResourceDto species) {
}
