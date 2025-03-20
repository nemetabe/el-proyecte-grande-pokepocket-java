package com.codecool.backend.model.pokemon;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "pokemon_species")
public class PokemonSpecies {
    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long pokeIndexNumber;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer baseHappiness = 70;

    private String evolutionTrigger; //  happiness

    private Integer evolutionThreshold;

}
