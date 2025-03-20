package com.codecool.backend.service;

import com.codecool.backend.controller.dto.UserPokemonDto;
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
import java.util.NoSuchElementException;
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

    public List<UserPokemonDto> checkHappinessEvolutions() {
        return userPokemonRepository.findPokemonReadyToEvolveByHappiness().stream()
                .map(UserPokemonDto::new)
                .toList();
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
    public UserPokemonDto evolvePokemon(Long pokemonId) {
        Optional<UserPokemon> optionalPokemon = userPokemonRepository.findById(pokemonId);

        if (optionalPokemon.isPresent()) {
            UserPokemon pokemon = optionalPokemon.get();

            if (!pokemon.getIsEvolutionPending()) {
                throw new IllegalStateException("Pokémon is not ready to evolve");
            }

            List<EvolutionChain> evolutions = evolutionChainRepository.findByBasePokemonId(pokemon.getSpeciesId());

            if (evolutions.isEmpty()) {
                pokemon.setIsEvolutionPending(false);
                UserPokemon userPokemon = userPokemonRepository.save(pokemon);
                return new UserPokemonDto(userPokemon);
            }

            EvolutionChain correctEvolution = null;

            for (EvolutionChain evolution : evolutions) {
                // Since all our evolutions are happiness-based with the same threshold (220),
                // we can just take the first one. In a more complex system with multiple
                // evolution paths, we'd need more logic here.
                correctEvolution = evolution;
                break;
            }

            if (correctEvolution == null) {
                throw new IllegalStateException("No suitable evolution found for this Pokémon");
            }

            Optional<PokemonSpecies> evolvedSpecies = pokemonSpeciesRepository.findById(correctEvolution.getEvolvedPokemonId());

            if (evolvedSpecies.isEmpty()) {
                throw new IllegalStateException("Evolved species not found");
            }

            PokemonAsset evolvedAsset = pokemonAssetRepository.findBySpeciesId(correctEvolution.getEvolvedPokemonId())
                    .orElseThrow(() -> new NoSuchElementException("Evolved species not found"));

            if (evolvedAsset == null) {
                throw new IllegalStateException("Assets for evolved form not found");
            }

            pokemon.setSpeciesId(correctEvolution.getEvolvedPokemonId());
            pokemon.setPictureUrl(evolvedAsset.getPictureUrl());
            pokemon.setGifUrl(evolvedAsset.getGifUrl());
            pokemon.setHappiness(evolvedSpecies.get().getBaseHappiness());
            pokemon.setIsEvolutionPending(false);

            UserPokemon userPokemon = userPokemonRepository.save(pokemon);
            return new UserPokemonDto(userPokemon);        }

        throw new IllegalArgumentException("Pokémon not found");
    }

    // TODO implement logic
    @Transactional
    public UserPokemonDto increaseHappiness(Long pokemonId, Integer amount) {
        Optional<UserPokemon> optionalPokemon = userPokemonRepository.findById(pokemonId);

        if (optionalPokemon.isPresent()) {
            UserPokemon pokemon = optionalPokemon.get();
            pokemon.setHappiness(Math.min(255, pokemon.getHappiness() + amount));
            UserPokemon userPokemon = userPokemonRepository.save(pokemon);
            return new UserPokemonDto(userPokemon);
        }

        throw new IllegalArgumentException("Pokémon not found");
    }

}
