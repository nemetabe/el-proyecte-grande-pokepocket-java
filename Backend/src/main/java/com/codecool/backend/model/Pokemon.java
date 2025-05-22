package com.codecool.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;
    private int evolutionState;
    private String image;
    private String gif;

    @ElementCollection(targetClass = Type.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "pokemon_type", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "type")
    private List<Type> types = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "pokemon_evolution",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "evolution_id")
    )
    private List<Pokemon> evolutions = new ArrayList<>();
}
