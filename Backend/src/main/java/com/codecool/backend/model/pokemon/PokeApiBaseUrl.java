package com.codecool.backend.model.pokemon;

public enum PokeApiBaseUrl {
    EVOLUTION("https://pokeapi.co/api/v2/evolution-chain/", "/"),
    SPECIES("https://pokeapi.co/api/v2/pokemon-species/", "/"),
    POKEMON("https://pokeapi.co/api/v2/pokemon/", "/"),
    CRY("https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/latest/", ".ogg"),
    PIC_URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/", ".png"),
    GIF_URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/shiny/",".gif"),
    SPRITE_FRONT("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/", ".png"),
    SPRITE_BACK("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/", ".png");


    private String url;
    private String pathEnd;

    PokeApiBaseUrl(String url, String pathEnd) {
        this.url = url;
        this.pathEnd = pathEnd;
    }

    public String getUrl() {
        return url;
    }
    public String getPathEnd() {
        return pathEnd;
    }

}
