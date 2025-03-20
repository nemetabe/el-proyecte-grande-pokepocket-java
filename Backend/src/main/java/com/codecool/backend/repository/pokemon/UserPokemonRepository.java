package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.UserPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPokemonRepository extends JpaRepository<UserPokemon, Long> {

    @Query("SELECT up FROM UserPokemon up JOIN EvolutionChain ec ON up.speciesId = ec.basePokemonId " +
            "WHERE ec.evolutionTrigger = 'happiness' AND up.happiness >= ec.minHappiness")
    public Optional<List<UserPokemon>> findPokemonReadyToEvolveByHappiness();
}
