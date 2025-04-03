insert into pokemon_assets(species_id, cry_audio_url, picture_url, sprite_back, sprite_front)
values (
           (SELECT id FROM pokemon_species WHERE poke_index_number = 172),
            'https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/latest/172.ogg',
            'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/172.png',
            'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/172.png',
           'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/172.png'
            ),(
            (SELECT id FROM pokemon_species WHERE poke_index_number = 25),
    'https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/latest/25.ogg',
    'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png',
    'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/25.png',
    'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png'
    ), ((SELECT id FROM pokemon_species WHERE poke_index_number = 26),
    'https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/latest/26.ogg',
    'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/26.png',
    'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/26.png',
    'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png'
    );