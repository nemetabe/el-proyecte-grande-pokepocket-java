package com.codecool.backend.controller.dto;

import com.codecool.backend.model.pokemon.Pokemon;

public record PokemonDto(Long id, String name, String img, String gif) {
    public PokemonDto(Pokemon pokemon){
        this(
        pokemon.getId(),
        pokemon.getName(),
        pokemon.getImage(),
                pokemon.getGif()
        );
    }
}
