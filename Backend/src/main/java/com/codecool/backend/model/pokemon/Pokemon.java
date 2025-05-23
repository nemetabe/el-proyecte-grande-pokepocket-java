package com.codecool.backend.model.pokemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private String gif;

    @ManyToMany
    private List<PokemonType> types;

    @ManyToOne
    private PokemonEvolution evolution;
}
