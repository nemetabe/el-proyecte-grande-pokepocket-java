package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.*;

@Data

@NoArgsConstructor
@Entity
@Table(name = "pokemon_assets")
public class PokemonAsset {
    @Getter
    @Setter
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "gif_url")
    private String gifUrl;

    @Column(name = "sprite_front")
    private String spriteFront;

    @Column(name = "sprite_back")
    private String spriteBack;

    @Column(name = "cry_audio_url")
    private String cryAudioUrl;

    @Column(name = "base_experience")
    private Integer baseExperience;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private PokemonSpecies species;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id")
    private EvolutionChain evolution;
}
