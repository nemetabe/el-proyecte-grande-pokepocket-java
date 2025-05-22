package com.codecool.backend.service;

import com.codecool.backend.controller.dto.PokemonChooseDto;
import com.codecool.backend.model.pokemon.Pokemon;
import com.codecool.backend.repository.PokemonEvolutionRepository;
import com.codecool.backend.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private PokemonRepository pokemonRepository;
    private PokemonEvolutionRepository pokemonEvolutionRepository;

    public PokemonService(PokemonRepository pokemonRepository, PokemonEvolutionRepository pokemonEvolutionRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonEvolutionRepository = pokemonEvolutionRepository;
    }

    public List<PokemonChooseDto> getAllBasePokemons() {
        List<Pokemon> phaseOnePokemons = pokemonEvolutionRepository.getAllPhaseOneId();
        return phaseOnePokemons.stream().map(PokemonChooseDto::new).collect(Collectors.toList());
    }

}
