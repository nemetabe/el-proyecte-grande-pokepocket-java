package com.codecool.backend.controller.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EvolutionChainDto(
        EvolutionStageDto chain,
        int id
) {}
