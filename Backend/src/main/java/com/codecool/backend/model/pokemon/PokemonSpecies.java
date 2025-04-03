package com.codecool.backend.model.pokemon;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "pokemon_species")
public class PokemonSpecies {
    @Getter
    @Setter
    @Id
    private Integer id;

    @Column(name = "poke_index_number", unique = true, nullable = false)
    private Integer pokeIndexNumber;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "variety", joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "pokemon_name")
    private Map<String, Integer> pokemons = new HashMap<>();

    private String description;

    @Column(name = "base_happiness", nullable = false)
    private Integer baseHappiness = 70;

    @ManyToOne
    @JoinColumn(name = "evolution_id", referencedColumnName = "id", nullable = false, updatable = false)
    private EvolutionChain evolutionChainId;
    //TODO

    @Column(name = "evolution_trigger")
    private String evolutionTrigger;

    @Column(name = "evolution_threshold")
    private Integer evolutionThreshold;

}
