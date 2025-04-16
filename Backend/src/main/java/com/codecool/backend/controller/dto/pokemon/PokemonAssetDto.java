package com.codecool.backend.controller.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonAssetDto(Integer id, String name, Integer baseExperience) {
}

