package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.PokemonAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonAssetRepository extends JpaRepository<PokemonAsset, Integer> {
    public Optional<PokemonAsset> findBySpeciesId(Integer speciesId);

}
