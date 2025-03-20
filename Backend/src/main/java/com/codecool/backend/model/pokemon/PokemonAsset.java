package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "pokemon_assets")
public class PokemonAsset {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "species_id", nullable = false)
    private Long speciesId;

    @Column(name = "picture_url", nullable = false)
    private String pictureUrl;

    @Column(name = "gif_url", nullable = false)
    private String gifUrl;

    @Column(name = "sprite_front")
    private String spriteFront;

    @Column(name = "sprite_back")
    private String spriteBack;

    @Column(name = "cry_audio_url")
    private String cryAudioUrl;

    @OneToOne
    @JoinColumn(name = "species_id", insertable = false, updatable = false)
    private PokemonSpecies species;
}
