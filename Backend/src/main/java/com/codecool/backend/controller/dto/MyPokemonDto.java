package com.codecool.backend.controller.dto;

import com.codecool.backend.model.pokemon.PokemonType;

import java.util.List;

public record MyPokemonDto(Long id, List<PokemonType> myPokemonTypes, List<PokemonDto> pokemons) {
}
