-- Insert Pokemon data for first generation Pokemon with their evolutions
-- Using PokeAPI URLs for images and GIFs

-- First evolution Pokemon
INSERT INTO pokemon (name, experience, evolution_state, image, gif) VALUES
('Bulbasaur', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif'),
('Charmander', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/4.gif'),
('Squirtle', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/7.gif'),
('Caterpie', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/10.gif'),
('Weedle', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/13.gif'),
('Pidgey', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/16.gif'),
('Rattata', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/19.gif'),
('Spearow', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/21.gif'),
('Ekans', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/23.gif'),
('Pikachu', 0, 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/25.gif');

-- Insert Pokemon types
INSERT INTO pokemon_type (pokemon_id, type) VALUES
(1, 'GRASS'),
(1, 'POISON'),
(2, 'FIRE'),
(3, 'WATER'),
(4, 'BUG'),
(5, 'BUG'),
(5, 'POISON'),
(6, 'NORMAL'),
(6, 'FLYING'),
(7, 'NORMAL'),
(8, 'NORMAL'),
(8, 'FLYING'),
(9, 'POISON'),
(10, 'ELECTRIC');

-- Insert evolution relationships
INSERT INTO pokemon_evolution (pokemon_id, evolution_id) VALUES
(1, 2), -- Bulbasaur -> Ivysaur
(2, 3), -- Ivysaur -> Venusaur
(4, 5), -- Charmander -> Charmeleon
(5, 6), -- Charmeleon -> Charizard
(7, 8), -- Squirtle -> Wartortle
(8, 9), -- Wartortle -> Blastoise
(10, 11), -- Caterpie -> Metapod
(11, 12), -- Metapod -> Butterfree
(13, 14), -- Weedle -> Kakuna
(14, 15), -- Kakuna -> Beedrill
(16, 17), -- Pidgey -> Pidgeotto
(17, 18), -- Pidgeotto -> Pidgeot
(19, 20), -- Rattata -> Raticate
(21, 22), -- Spearow -> Fearow
(23, 24), -- Ekans -> Arbok
(25, 26); -- Pikachu -> Raichu
