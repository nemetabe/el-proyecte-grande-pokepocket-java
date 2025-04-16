package com.codecool.backend.controller.dto;

import com.codecool.backend.model.pokemon.PokemonSpecies;
import com.codecool.backend.model.pokemon.UserPokemon;

import java.time.LocalDateTime;

public record UserPokemonDto(Long pokemonId, Integer experience, PokemonSpecies species, String nickName, Integer happiness, String pictureUrl,  String gifUrl, LocalDateTime hatchDate, Boolean isEvolutionPending ) {

    public UserPokemonDto(UserPokemon userPokemon) {
        this(userPokemon.getId(),
                userPokemon.getExperience(),
                userPokemon.getSpecies(),
                userPokemon.getNickname(),
                userPokemon.getHappiness(),
                userPokemon.getPictureUrl(),
                userPokemon.getGifUrl(),
                userPokemon.getHatchDate(),
                userPokemon.getIsEvolutionPending());
    }
}
