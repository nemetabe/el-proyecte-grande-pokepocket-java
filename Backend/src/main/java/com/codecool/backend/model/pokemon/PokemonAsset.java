package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "pokemon_assets")
public class PokemonAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetId;

    @Column(nullable = false)
    private Long speciesId;

    @Column(nullable = false)
    private String pictureUrl;

    @Column(nullable = false)
    private String gifUrl;

    private String spriteFront;

    private String spriteBack;

    private String cryAudioUrl;

    @OneToOne
    @JoinColumn(name = "speciesId", insertable = false, updatable = false)
    private PokemonSpecies species;
}
