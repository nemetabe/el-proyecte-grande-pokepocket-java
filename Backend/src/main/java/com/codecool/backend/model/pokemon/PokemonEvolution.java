package com.codecool.backend.model.pokemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PokemonEvolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pokemon phaseOne;

    @OneToOne
    private Pokemon phaseTwo;

    @OneToOne
    private Pokemon phaseThree;
}
