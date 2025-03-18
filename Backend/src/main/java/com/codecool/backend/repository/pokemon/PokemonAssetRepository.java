package com.codecool.backend.repository.pokemon;

import com.codecool.backend.model.pokemon.PokemonAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonAssetRepository extends JpaRepository<PokemonAsset, Integer> {
    PokemonAsset findBySpeciesId(Long speciesId);

}
