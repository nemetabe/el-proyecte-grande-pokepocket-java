package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.EvolutionChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvolutionChainRepository extends JpaRepository<EvolutionChain, Integer> {

    @Query("SELECT ec FROM EvolutionChain ec JOIN PokemonSpecies ps ON ps.name = ec.evolutions[0]" +
    "WHERE ps.id = ?1")
    public Optional<List<EvolutionChain>> findEvolutionChainBySpeciesId(Integer speciesId);

}
