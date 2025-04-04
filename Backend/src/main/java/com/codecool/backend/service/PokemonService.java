package com.codecool.backend.service;

import com.codecool.backend.controller.exception.PokemonNotFoundException;
import com.codecool.backend.model.pokemon.*;
import com.codecool.backend.repository.pokemon.EvolutionChainRepository;
import com.codecool.backend.repository.pokemon.PokemonAssetRepository;
import com.codecool.backend.repository.pokemon.PokemonSpeciesRepository;
import com.codecool.backend.repository.pokemon.UserPokemonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class PokemonService {
    private final PokemonAssetRepository pokemonAssetRepository;
    private final EvolutionChainRepository evolutionChainRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final UserPokemonRepository userPokemonRepository;
    private final PokemonSpeciesRepository pokemonSpeciesRepository;

    @Autowired
    public PokemonService(PokemonAssetRepository pokemonAssetRepository,
                          EvolutionChainRepository evolutionChainRepository,
                          UserPokemonRepository userPokemonRepository,
                          PokemonSpeciesRepository pokemonSpeciesRepository) {
        this.pokemonAssetRepository = pokemonAssetRepository;
        this.evolutionChainRepository = evolutionChainRepository;
        this.userPokemonRepository = userPokemonRepository;
        this.pokemonSpeciesRepository = pokemonSpeciesRepository;

    }

    @PostConstruct
    public void fetchInitialData() {
        if (evolutionChainRepository.count() == 0) {
            fetchEvolutionChains();
        }

        if (pokemonSpeciesRepository.count() == 0) {
            fetchSpeciesByEvolution();
        }

    }

//    private void fetchSpeciesByEvolution() {
//        evolutionChainRepository.findAll()
//                .forEach(evolutionChain -> fetchSpecies(evolutionChain.getEvolutions()          }
//    }
//    private void fetchSpecies(){
//
//
//    }//TODO

    private void fetchPokemons(List<String> pokemonNames, String speciesName, Integer speciesId ) {
        for (String pokemonName : pokemonNames) {
            fetchPokemon(speciesId, pokemonName);
        }
    }

    private void fetchPokemon(Integer speciesId, String pokemonName) {
        try {
            String url = getUrl(pokemonName);
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response != null) {
                String name = (String) response.get("name");
                Integer pokeIndex = (Integer) response.get("id");
                String id = pokeIndex.toString();


                PokemonSpecies species = pokemonSpeciesRepository.findPokemonSpeciesBy(speciesId).orElseThrow(
                        () -> new PokemonNotFoundException("Species not found in database")
                );

                PokemonSpecies speciesByName = pokemonSpeciesRepository.findPokemonSpeciesBy(speciesId).orElseThrow(
                        () -> new PokemonNotFoundException("Species not found in database")
                );

                PokemonSpecies pokemonSpecies = pokemonSpeciesRepository.findByPokeIndexNumber(pokeIndex).orElseThrow(
                        () -> new PokemonNotFoundException("Species not found in database")
                );
                EvolutionChain evolutionChain = evolutionChainRepository.findById(speciesId).orElseThrow(
                        () -> new PokemonNotFoundException("Evolution chain not found in database")
                );

                PokemonAsset pokemonAsset = createPokemonAsset(id, name, pokemonSpecies, evolutionChain);
                pokemonAssetRepository.save(pokemonAsset);
            }
        } catch (Exception e) {
            System.err.println("Error fetching Pokémon: " + e.getMessage());

        }
    }

private static String getUrl(String pokemonName) {
    String url = PokeApiBaseUrl.POKEMON.getUrl() + pokemonName + PokeApiBaseUrl.POKEMON.getPathEnd();
    return url;
}


private PokemonAsset createPokemonAsset(String id, String speciesName, PokemonSpecies species, EvolutionChain evolution) {
        if (species == null || evolution == null) {
            System.out.println("Error creating pokemon asset");
            return null;
        };
        String pictureUrl = PokeApiBaseUrl.PIC_URL.getUrl() + id +  PokeApiBaseUrl.PIC_URL.getPathEnd();
        String gifUrl = PokeApiBaseUrl.GIF_URL.getUrl() + id +  PokeApiBaseUrl.GIF_URL.getPathEnd();
        String spriteFront = PokeApiBaseUrl.SPRITE_FRONT.getUrl() + id +  PokeApiBaseUrl.SPRITE_FRONT.getPathEnd();
        String spriteBack = PokeApiBaseUrl.SPRITE_BACK.getUrl() + id +  PokeApiBaseUrl.SPRITE_BACK.getPathEnd();
        String cryAudioUrl =PokeApiBaseUrl.CRY.getUrl() + id +  PokeApiBaseUrl.CRY.getPathEnd();
            PokemonAsset poke = new PokemonAsset(
                    Integer.parseInt(id),
                    speciesName,
                    pictureUrl,
                    gifUrl,
                    spriteFront,
                    spriteBack,
                    cryAudioUrl,
                    species,
                    evolution
            );
            return poke;
    }


    private void fetchEvolutionChains() {
        for (int id = 1; id <= 10; id++) {
            try {
                String url = PokeApiBaseUrl.EVOLUTION.getUrl() + String.valueOf(id) + PokeApiBaseUrl.EVOLUTION.getPathEnd();
                Map<String, Object> response = restTemplate.getForObject(url, Map.class);

                if (response != null) {
                    Map<String, Object> chain = (Map<String, Object>) response.get("chain");
                    EvolutionChain evolutionChain = parseEvolutionChain(id, chain);
                    if (evolutionChain != null) {
                        evolutionChainRepository.save(evolutionChain);
                        //fetchPokemons(evolutionChain.getEvolutions().stream().toList(), extractSpeciesKey(chain, "name"), extractSpeciesKey(chain));
                    }
                }
            } catch (Exception e) {
                System.err.println("Error fetching evolution chain " + id + ": " + e.getMessage());
            }
        }
    }

    private EvolutionChain parseEvolutionChain(Integer id, Map<String, Object> chain) {
        if (chain == null) return null;

        List<String> evolutions = new ArrayList<>();
        List<Integer> evolutionIds = new ArrayList<>();
        String speciesName = extractSpeciesKey(chain, "name");
        Integer speciesId = extractSpeciesKey(chain);
        extractEvolutions(chain, evolutions, evolutionIds);

        return new EvolutionChain(id, evolutions, evolutionIds);
    }

    private void extractEvolutions(Map<String, Object> chain, List<String> evolutions, List<Integer> evolutionIds) {
        while (chain != null) {
            List<Map<String, Object>> evolvesTo = (List<Map<String, Object>>) chain.get("evolves_to");

            if (evolvesTo != null && !evolvesTo.isEmpty()) {
                chain = evolvesTo.get(0);  // Assume first evolution path
                evolutions.add(extractSpeciesKey(chain, "name"));
                evolutionIds.add(extractSpeciesKey(chain));
            } else {
                break;
            }
        }
    }

    private String extractSpeciesKey(Map<String, Object> chain, String key) {
        Map<String, Object> species = (Map<String, Object>) chain.get("species");
        return species != null ? (String) species.get(key) : "Unknown";
    }

    private Integer extractSpeciesKey(Map<String, Object> chain) {
        Map<String, Object> species = (Map<String, Object>) chain.get("species");
        String speciesUrl = (String) species.get("url");
        String[] split = speciesUrl.split("/");
        Integer speciesId = split.length > 1 ? Integer.parseInt(split[split.length - 1]) : null;
        return speciesId;
    }

    public List<UserPokemon> getUserPokemons() {//TODO
        return userPokemonRepository.findAll();
    }

    public List<EvolutionChain> getEvolutionChains() {
        return evolutionChainRepository.findAll();
    }

    public void addUserPokemon(UserPokemon pokemon) {
        userPokemonRepository.save(pokemon);
    }
}