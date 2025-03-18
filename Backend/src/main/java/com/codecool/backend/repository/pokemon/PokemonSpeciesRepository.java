package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.PokemonSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonSpeciesRepository extends JpaRepository {
    PokemonSpecies findByName(String name);
}
