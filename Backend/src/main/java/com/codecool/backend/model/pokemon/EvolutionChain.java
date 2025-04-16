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

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "evolution_chain")
public class EvolutionChain {

    @Id
    private Integer id;

    @OneToMany(mappedBy = "evolutionChain", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PokemonSpecies> evolutions = new ArrayList<>();

    public EvolutionChain() {}

    public EvolutionChain(Integer id, List<PokemonSpecies> evolutions) {
        this.id = id;
        this.evolutions = evolutions;
    }

    public PokemonSpecies getBasePokemon() { return evolutions != null ? evolutions.get(0) : null; }


    public void addSpecies(PokemonSpecies species) {
        evolutions.add(species);
        species.setEvolutionChain(this);
    }

    public void removeSpecies(PokemonSpecies species) {
        evolutions.remove(species);
        species.setEvolutionChain(null);
    }

    public PokemonSpecies getCurrentEvolution(Integer currentEvolution) {
        if (evolutions != null && currentEvolution < evolutions.size()) {
            return evolutions.get(currentEvolution);
        }
        return null;
    }
    public PokemonSpecies getNextEvolution(Integer currentEvolution) {
        if (evolutions != null && currentEvolution + 1 < evolutions.size()) {
            return evolutions.get(currentEvolution + 1);
        }
        return null;
    }
}