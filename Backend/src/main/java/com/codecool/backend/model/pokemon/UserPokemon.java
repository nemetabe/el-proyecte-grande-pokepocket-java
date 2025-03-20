package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_pokemon")
public class UserPokemon {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long speciesId;

    @Column(nullable = false)
    private Long userId;

    private String nickname;

    @Column(nullable = false)
    private Integer happiness = 70;

    @Column(nullable = false)
    private String pictureUrl;

    @Column(nullable = false)
    private String gifUrl;

    @Column(nullable = false)
    private LocalDateTime hatchDate = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean isEvolutionPending = false;

    @ManyToOne
    @JoinColumn(name = "speciesId", insertable = false, updatable = false)
    private PokemonSpecies species;
}
