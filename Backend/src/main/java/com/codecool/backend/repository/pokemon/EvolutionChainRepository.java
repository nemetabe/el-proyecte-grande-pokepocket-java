package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.EvolutionChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvolutionChainRepository extends JpaRepository<EvolutionChain, Integer> {
    public Optional<List<EvolutionChain>> findByBasePokemonId(Long basePokemonId);

}
