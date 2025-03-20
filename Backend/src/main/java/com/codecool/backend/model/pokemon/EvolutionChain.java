package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "evolution_chains",
        uniqueConstraints = @UniqueConstraint(columnNames = {"basePokemonId", "evolvedPokemonId"}))
public class EvolutionChain {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long basePokemonId;

    @Column(nullable = false)
    private Long evolvedPokemonId;

    @Column(nullable = false)
    private String evolutionTrigger;

    private Integer minHappiness;

//    private String itemRequired;

    @ManyToOne
    @JoinColumn(name = "basePokemonId", insertable = false, updatable = false)
    private PokemonSpecies basePokemon;

    @ManyToOne
    @JoinColumn(name = "evolvedPokemonId", insertable = false, updatable = false)
    private PokemonSpecies evolvedPokemon;


}
