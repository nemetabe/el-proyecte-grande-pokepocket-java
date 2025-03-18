package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.EvolutionChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvolutionChainRepository extends JpaRepository<EvolutionChain, Integer> {
    List<EvolutionChain> findByBasePokemonId(Long basePokemonId);

}
