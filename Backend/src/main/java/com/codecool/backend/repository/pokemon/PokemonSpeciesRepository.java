package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.PokemonSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonSpeciesRepository extends JpaRepository <PokemonSpecies, Long> {
    public Optional<PokemonSpecies> findByName(String name);
    public Optional<PokemonSpecies> findByPokeIndexNumber(Long pokeIndexNumber);

}
