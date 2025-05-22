package com.codecool.backend.controller;

import com.codecool.backend.model.Pokemon;
import com.codecool.backend.repository.PokemonRepository;
import com.codecool.backend.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/all")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

}
