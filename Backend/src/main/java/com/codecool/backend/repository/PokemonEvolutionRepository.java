package com.codecool.backend.repository;

import com.codecool.backend.model.pokemon.Pokemon;
import com.codecool.backend.model.pokemon.PokemonEvolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonEvolutionRepository extends JpaRepository<PokemonEvolution, Long> {

    @Query("SELECT p.phaseOne FROM PokemonEvolution p")
    List<Pokemon> getAllPhaseOneId();
}
