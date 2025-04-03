package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pokemon_assets",
        uniqueConstraints = @UniqueConstraint(columnNames = {"species_id", "evolution_id"}))
public class PokemonAsset {
    @Getter
    @Setter
    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

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

//    @Column(name = "experience")
//    private Integer experience;

    @OneToOne
    @JoinColumn(name = "species_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PokemonSpecies species;
}
