package com.codecool.backend.repository;

import com.codecool.backend.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
}
