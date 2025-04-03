package com.codecool.backend.model.pokemon;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//@Data
//@Entity
//@Table(name = "evolution_chains",
//        uniqueConstraints = @UniqueConstraint(columnNames = {"basePokemonId", "evolvedPokemonId"}))
//public class EvolutionChain {
//
//    @Getter
//    @Setter
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "evolution_trigger", nullable = false)
//    private String evolutionTrigger;
//
//    @Column(name = "min_happiness", nullable = false)
//    private Integer minHappiness;
//
////    private String itemRequired;
//
//    @Column(name = "evolution_chain_id", nullable = false)
//    private Integer evolutionChainId;
//
//    @ManyToOne
//    @JoinColumn(name = "base_pokemon_id", insertable = false, updatable = false)
//    private PokemonSpecies basePokemon;
//
//    @ManyToOne
//    @JoinColumn(name = "evolved_pokemon_id", insertable = false, updatable = false)
//    private PokemonSpecies evolvedPokemon;
//
//
//}

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "evolution_chain")
public class EvolutionChain {

    @Id
    private Integer id;


    @ElementCollection
    private List<String> evolutions;


    @ElementCollection
    private List<Integer> evolutionIds;

    private Integer evolutionTracker;

    public EvolutionChain() {}

    public EvolutionChain(Integer id, List<String> evolutions, List<Integer> evolutionIds) {
        this.id = id;
        this.evolutions = evolutions;
        this.evolutionIds = evolutionIds;
        this.evolutionTracker = 0;
    }

    public String getBasePokemon() { return evolutions != null ? evolutions.get(0) : null; }

    public void setEvolutionTracker(Integer increment) {
        this.evolutionTracker += increment;
    }

    public String getCurrentEvolution() {
        return evolutions != null ? evolutions.get(evolutionTracker) : null;
    }
}