package com.codecool.backend.service;

import com.codecool.backend.model.Pokemon;
import com.codecool.backend.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

}
