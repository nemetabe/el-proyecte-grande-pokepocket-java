package com.codecool.backend.service;

import com.codecool.backend.model.pokemon.EvolutionChain;
import com.codecool.backend.model.pokemon.PokemonAsset;
import com.codecool.backend.model.pokemon.PokemonSpecies;
import com.codecool.backend.model.pokemon.UserPokemon;
import com.codecool.backend.repository.pokemon.EvolutionChainRepository;
import com.codecool.backend.repository.pokemon.PokemonAssetRepository;
import com.codecool.backend.repository.pokemon.PokemonSpeciesRepository;
import com.codecool.backend.repository.pokemon.UserPokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonEvolutionService {

    @Autowired
    private UserPokemonRepository userPokemonRepository;

    @Autowired
    private EvolutionChainRepository evolutionChainRepository;

    @Autowired
    private PokemonSpeciesRepository pokemonSpeciesRepository;

    @Autowired
    private PokemonAssetRepository pokemonAssetRepository;

    public List<UserPokemon> checkHappinessEvolutions() {
        return userPokemonRepository.findPokemonReadyToEvolveByHappiness();
    }

    /**
     * Mark a Pokémon as ready to evolve
     */
    @Transactional
    public boolean markForEvolution(Long pokemonId) {
        Optional<UserPokemon> optionalPokemon = userPokemonRepository.findById(pokemonId);

        if (optionalPokemon.isPresent()) {
            UserPokemon pokemon = optionalPokemon.get();
            pokemon.setIsEvolutionPending(true);
            userPokemonRepository.save(pokemon);
            return true;
        }

        return false;
    }

    @Transactional
    public UserPokemon evolvePokemon(Long pokemonId) {
        Optional<UserPokemon> optionalPokemon = userPokemonRepository.findById(pokemonId);

        if (optionalPokemon.isPresent()) {
            UserPokemon pokemon = optionalPokemon.get();

            if (!pokemon.getIsEvolutionPending()) {
                throw new IllegalStateException("Pokémon is not ready to evolve");
            }

            List<EvolutionChain> evolutions = evolutionChainRepository.findByBasePokemonId(pokemon.getSpeciesId());

            if (evolutions.isEmpty()) {
                throw new IllegalStateException("No evolution found for this Pokémon");
            }


            // Get the first evolution (we should have logic to choose correct one if multiple)  !!!!!!!!
            // TODO:
            EvolutionChain evolution = evolutions.get(0);


            Optional<PokemonSpecies> evolvedSpecies = pokemonSpeciesRepository.findById(evolution.getEvolvedPokemonId());

            if (evolvedSpecies.isEmpty()) {
                throw new IllegalStateException("Evolved species not found");
            }

            PokemonAsset evolvedAsset = pokemonAssetRepository.findBySpeciesId(evolution.getEvolvedPokemonId());

            if (evolvedAsset == null) {
                throw new IllegalStateException("Assets for evolved form not found");
            }

            pokemon.setSpeciesId(evolution.getEvolvedPokemonId());
            pokemon.setPictureUrl(evolvedAsset.getPictureUrl());
            pokemon.setGifUrl(evolvedAsset.getGifUrl());
            pokemon.setHappiness(evolvedSpecies.get().getBaseHappiness());
            pokemon.setIsEvolutionPending(false);

            return userPokemonRepository.save(pokemon);
        }

        throw new IllegalArgumentException("Pokémon not found");
    }

    // TODO implement logic
    @Transactional
    public UserPokemon increaseHappiness(Long pokemonId, Integer amount) {
        Optional<UserPokemon> optionalPokemon = userPokemonRepository.findById(pokemonId);

        if (optionalPokemon.isPresent()) {
            UserPokemon pokemon = optionalPokemon.get();
            pokemon.setHappiness(Math.min(255, pokemon.getHappiness() + amount));
            return userPokemonRepository.save(pokemon);
        }

        throw new IllegalArgumentException("Pokémon not found");
    }

}
