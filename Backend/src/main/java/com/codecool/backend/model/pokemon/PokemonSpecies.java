package com.codecool.backend.model.pokemon;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "pokemon_species")
public class PokemonSpecies {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "poke_index_number", unique = true, nullable = false)
    private Long pokeIndexNumber;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "base_happiness", nullable = false)
    private Integer baseHappiness = 70;

    @Column(name = "evolution_trigger")
    private String evolutionTrigger;

    @Column(name = "evolution_threshold")
    private Integer evolutionThreshold;

}
