package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.EvolutionChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvolutionChainRepository extends JpaRepository<EvolutionChain, Integer> {

    @Query(value = "SELECT ece FROM evolution_chain_evolutions ece " +
            "JOIN evolution_chain ec ON ece.evolution_chain_id = ec.id " +
            "JOIN pokemon_species ps ON ps.evolution_id = ec.id " +
            "WHERE ps.evolution_id = ece.evolution_chain_id",
            nativeQuery = true)
    public Optional<List<EvolutionChain>> findEvolutionChainBySpeciesId();

}
