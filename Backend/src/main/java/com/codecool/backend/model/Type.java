package com.codecool.backend.model;

public enum Type {
    NORMAL("Normal", "#A8A77A"),
    FIRE("Fire", "#EE8130"),
    WATER("Water", "#6390F0"),
    ELECTRIC("Electric", "#F7D02C"),
    GRASS("Grass", "#7AC74C"),
    ICE("Ice", "#96D9D6"),
    FIGHTING("Fighting", "#C22E28"),
    POISON("Poison", "#A33EA1"),
    GROUND("Ground", "#E2BF65"),
    FLYING("Flying", "#A98FF3"),
    PSYCHIC("Psychic", "#F95587"),
    BUG("Bug", "#A6B91A"),
    ROCK("Rock", "#B6A136"),
    GHOST("Ghost", "#735797"),
    DRAGON("Dragon", "#6F35FC"),
    DARK("Dark", "#705746"),
    STEEL("Steel", "#B7B7CE"),
    FAIRY("Fairy", "#D685AD");

    private final String name;
    private final String color;

    Type(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
