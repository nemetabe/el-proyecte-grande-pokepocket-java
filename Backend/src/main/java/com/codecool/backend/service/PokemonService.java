package com.codecool.backend.service;

import com.codecool.backend.controller.dto.PokemonDto;
import com.codecool.backend.model.pokemon.Pokemon;
import com.codecool.backend.repository.PokemonEvolutionRepository;
import com.codecool.backend.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private PokemonEvolutionRepository pokemonEvolutionRepository;

    public PokemonService(PokemonEvolutionRepository pokemonEvolutionRepository) {
        this.pokemonEvolutionRepository = pokemonEvolutionRepository;
    }

    public List<PokemonDto> getAllBasePokemons() {
        List<Pokemon> phaseOnePokemons = pokemonEvolutionRepository.getAllPhaseOneId();
        return phaseOnePokemons.stream().map(PokemonDto::new).collect(Collectors.toList());
    }

}
