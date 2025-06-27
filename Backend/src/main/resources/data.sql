
-- Insert Pokemons
INSERT INTO pokemon (name, experience, image, gif) VALUES
('Bulbasaur', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif'),
('Ivysaur', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/2.gif'),
('Venusaur', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/3.gif'),
('Charmander', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/4.gif'),
('Charmilion', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/5.gif'),
('Charizard', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/6.gif');

-- ('Squirtle', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/7.gif'),
--
-- ('Caterpie', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/10.gif'),
--
-- ('Weedle', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/13.gif'),
--
-- ('Pidgey', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/16.gif'),
--
-- ('Rattata', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/19.gif'),
--
-- ('Spearow', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/21.gif'),
--
-- ('Ekans', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/23.gif'),
--
-- ('Pikachu', 0, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/25.gif');

-- Insert Pokemon types
INSERT INTO pokemon_types (pokemon_id, types_id) VALUES
(1, 5),
(1, 8),
(2, 5),
(2, 8),
(3, 5),
(3, 8),
(4, 2),
(5, 2),
(6, 2);
-- (3, 'WATER'),
-- (4, 'BUG'),
-- (5, 'BUG'),
-- (5, 'POISON'),
-- (6, 'NORMAL'),
-- (6, 'FLYING'),
-- (7, 'NORMAL'),
-- (8, 'NORMAL'),
-- (8, 'FLYING'),
-- (9, 'POISON'),
-- (10, 'ELECTRIC');

INSERT INTO pokemon_evolution (phase_one_id, phase_two_id, phase_three_id) VALUES
(1, 2, 3),
(4, 5, 6);
