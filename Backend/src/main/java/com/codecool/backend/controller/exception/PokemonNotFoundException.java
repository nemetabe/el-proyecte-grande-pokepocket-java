package com.codecool.backend.controller.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException() {
        super("You dont have a pokemon");
    }
}
