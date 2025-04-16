package com.codecool.backend.controller.dto.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonSpeciesDto(String name,
                                Integer id,
                                Integer baseHappiness,
                                List<PokemonSpeciesVarietyDto> varieties,
                                String description) {}