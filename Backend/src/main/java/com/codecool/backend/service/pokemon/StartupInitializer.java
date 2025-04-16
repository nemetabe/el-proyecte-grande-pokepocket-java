package com.codecool.backend.service.pokemon;

import com.codecool.backend.service.PokemonService;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupInitializer {
    private final PokemonService pokemonService;

    public StartupInitializer(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {}

}
