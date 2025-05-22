package com.codecool.backend.repository;

import com.codecool.backend.model.pokemon.PokemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonTypeRepository extends JpaRepository<PokemonType, Long> {
}
