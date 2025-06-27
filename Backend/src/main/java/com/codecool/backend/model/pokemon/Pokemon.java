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

    private int experience;

    private String image;

    private String gif;

    @ManyToMany
    private List<PokemonType> types;

    @OneToOne
    private PokemonEvolution evolution;

    //fire - 2
    //grass - 5
    //poison - 8
}
