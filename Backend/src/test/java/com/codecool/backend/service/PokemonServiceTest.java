package com.codecool.backend.service;

import com.codecool.backend.controller.dto.PokemonDto;
import com.codecool.backend.model.pokemon.Pokemon;
import com.codecool.backend.repository.PokemonEvolutionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @Mock
    private PokemonEvolutionRepository pokemonEvolutionRepository;

    private PokemonService pokemonService;

    @BeforeEach
    void setUp() {
        pokemonService = new PokemonService(pokemonEvolutionRepository);
    }

    @Test
    void getAllBasePokemons_returnsListOfPokemonDto() {
        // Arrange
        Pokemon pokemon1 = new Pokemon();
        pokemon1.setId(1L);
        pokemon1.setName("Bulbasaur");
        pokemon1.setImage("bulbasaur.png");
        pokemon1.setGif("bulbasaur.gif");

        Pokemon pokemon2 = new Pokemon();
        pokemon2.setId(2L);
        pokemon2.setName("Charmander");
        pokemon2.setImage("charmander.png");
        pokemon2.setGif("charmander.gif");

        List<Pokemon> basePokemons = List.of(pokemon1, pokemon2);
        when(pokemonEvolutionRepository.getAllPhaseOneId()).thenReturn(basePokemons);

        // Act
        List<PokemonDto> result = pokemonService.getAllBasePokemons();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        // Verify first Pokemon
        assertEquals(1L, result.get(0).id());
        assertEquals("Bulbasaur", result.get(0).name());
        assertEquals("bulbasaur.png", result.get(0).img());
        assertEquals("bulbasaur.gif", result.get(0).gif());
        
        // Verify second Pokemon
        assertEquals(2L, result.get(1).id());
        assertEquals("Charmander", result.get(1).name());
        assertEquals("charmander.png", result.get(1).img());
        assertEquals("charmander.gif", result.get(1).gif());
    }

    @Test
    void getAllBasePokemons_whenNoPokemons_returnsEmptyList() {
        // Arrange
        when(pokemonEvolutionRepository.getAllPhaseOneId()).thenReturn(List.of());

        // Act
        List<PokemonDto> result = pokemonService.getAllBasePokemons();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
} 