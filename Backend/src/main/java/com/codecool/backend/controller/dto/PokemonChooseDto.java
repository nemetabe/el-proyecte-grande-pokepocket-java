package com.codecool.backend.controller.dto;

import com.codecool.backend.model.pokemon.Pokemon;

public record PokemonChooseDto(Long id, String name, String img) {
    public PokemonChooseDto(Pokemon pokemon){
        this(
        pokemon.getId(),
        pokemon.getName(),
        pokemon.getImage()
        );
    }
}
