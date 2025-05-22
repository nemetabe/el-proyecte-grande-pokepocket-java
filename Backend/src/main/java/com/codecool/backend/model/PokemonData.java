package com.codecool.backend.model;

import java.util.List;
import java.util.Map;

public enum PokemonData {
    BULBASAUR("Bulbasaur", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif",
        List.of(Type.GRASS, Type.POISON)),

    CHARMANDER("Charmander", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/4.gif",
        List.of(Type.FIRE)),

    SQUIRTLE("Squirtle", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/7.gif",
        List.of(Type.WATER)),

    CATERPIE("Caterpie", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/10.gif",
        List.of(Type.BUG)),

    WEEDLE("Weedle", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/13.gif",
        List.of(Type.BUG, Type.POISON)),

    PIDGEY("Pidgey", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/16.gif",
        List.of(Type.NORMAL, Type.FLYING)),

    RATTATA("Rattata", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/19.gif",
        List.of(Type.NORMAL)),

    SPEAROW("Spearow", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/21.gif",
        List.of(Type.NORMAL, Type.FLYING)),

    EKANS("Ekans", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/23.gif",
        List.of(Type.POISON)),

    PIKACHU("Pikachu", 0, 1,
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/25.gif",
        List.of(Type.ELECTRIC));

    private final String name;
    private final int experience;
    private final int evolutionState;
    private final String image;
    private final String gif;
    private final List<Type> types;

    PokemonData(String name, int experience, int evolutionState, String image, String gif, List<Type> types) {
        this.name = name;
        this.experience = experience;
        this.evolutionState = evolutionState;
        this.image = image;
        this.gif = gif;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getEvolutionState() {
        return evolutionState;
    }

    public String getImage() {
        return image;
    }

    public String getGif() {
        return gif;
    }

    public List<Type> getTypes() {
        return types;
    }

    public static Map<PokemonData, PokemonData> getEvolutionMap() {
        return Map.of(
            BULBASAUR, CHARMANDER,  // Bulbasaur -> Charmander
            CHARMANDER, SQUIRTLE,   // Charmander -> Squirtle
            SQUIRTLE, CATERPIE,     // Squirtle -> Caterpie
            CATERPIE, WEEDLE,       // Caterpie -> Weedle
            WEEDLE, PIDGEY,         // Weedle -> Pidgey
            PIDGEY, RATTATA,        // Pidgey -> Rattata
            RATTATA, SPEAROW,       // Rattata -> Spearow
            SPEAROW, EKANS,         // Spearow -> Ekans
            EKANS, PIKACHU          // Ekans -> Pikachu
        );
    }
}
