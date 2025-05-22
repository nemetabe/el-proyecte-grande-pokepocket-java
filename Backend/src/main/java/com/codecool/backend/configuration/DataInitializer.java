package com.codecool.backend.configuration;
import com.codecool.backend.model.pokemon.PokemonType;
import com.codecool.backend.model.transaction.Category;
import com.codecool.backend.repository.CategoryRepository;
import com.codecool.backend.repository.PokemonTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration

public class DataInitializer {

    @Bean
    public CommandLineRunner initCategories(CategoryRepository categoryRepository) {
        return args -> {
            // Only populate if empty
            if (categoryRepository.count() == 0) {
                for (Category.CategoryType type : Category.CategoryType.values()) {
                    categoryRepository.save(new Category(type));
                }
                categoryRepository.flush();
            }
        };
    }

    @Bean
    @Order(1)
    public CommandLineRunner initPokemonTypes(PokemonTypeRepository pokemonTypeRepository) {
        return args -> {
            if (pokemonTypeRepository.count() == 0) {
                for (PokemonType.Type type : PokemonType.Type.values()) {
                        pokemonTypeRepository.save(new PokemonType(type));
                }
            }
        };
    }
}
