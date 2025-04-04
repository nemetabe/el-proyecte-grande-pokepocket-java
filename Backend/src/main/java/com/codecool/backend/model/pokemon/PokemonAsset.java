package com.codecool.backend.model.pokemon;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "sprite_front", nullable = false)
    private String spriteFront;

    @Column(name = "sprite_back", nullable = false)
    private String spriteBack;

    @Column(name = "cry_audio_url", nullable = false)
    private String cryAudioUrl;

//    @Column(name = "experience")
//    private Integer experience;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", insertable = false, updatable = false)
    private PokemonSpecies species;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", insertable = false, updatable = false)
    private EvolutionChain evolution;
}
