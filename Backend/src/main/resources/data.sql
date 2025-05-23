INSERT INTO pokemon (name, image, gif) VALUES
                                           ('Bulbasaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/1.gif'),
                                           ('Ivysaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/2.gif'),
                                           ('Venusaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/3.gif'),
                                           ('Charmander', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/4.gif'),
                                           ('Charmilion', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/5.gif'),
                                           ('Charizard', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/6.gif'),
                                           ('Squirtle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/7.gif'),
                                           ('Wartortle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/8.gif'),
                                           ('Blastoise', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/9.gif'),
                                           ('Caterpie', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/10.gif'),
                                           ('Metapod', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/11.gif'),
                                           ('Butterfree', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/12.gif'),
                                           ('Weedle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/13.gif'),
                                           ('Kakuna', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/14.gif'),
                                           ('Beedrill', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/15.gif'),
                                           ('Pidgey', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/16.gif'),
                                           ('Pidgeotto', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/17.gif'),
                                           ('Pidgeot', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/18.gif'),
                                           ('Pichu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/172.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/172.gif'),
                                           ('Pikachu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/25.gif'),
                                           ('Raichu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/26.gif');

INSERT INTO pokemon_types (pokemon_id, types_id) VALUES
                                                     (1, 5),
                                                     (1, 8),
                                                     (2, 5),
                                                     (2, 8),
                                                     (3, 5),
                                                     (3, 8),
                                                     (4, 2),
                                                     (5, 2),
                                                     (6, 2),
                                                     (6, 10),
                                                     (7, 3),
                                                     (8, 3),
                                                     (9, 3),
                                                     (10, 12),
                                                     (11, 12),
                                                     (12, 12),
                                                     (12, 10),
                                                     (13, 12),
                                                     (13, 8),
                                                     (14, 12),
                                                     (14, 8),
                                                     (15, 12),
                                                     (15, 8),
                                                     (16, 1),
                                                     (16, 10),
                                                     (17, 1),
                                                     (17, 10),
                                                     (18, 1),
                                                     (18, 10),
                                                     (19, 4),
                                                     (20, 4),
                                                     (21, 4);

INSERT INTO pokemon_evolution (phase_one_id, phase_two_id, phase_three_id) VALUES
                                                                               (1, 2, 3),
                                                                               (4, 5, 6),
                                                                               (7, 8, 9),
                                                                               (10, 11, 12),
                                                                               (13, 14, 15),
                                                                               (16, 17, 18),
                                                                               (19, 20, 21);

UPDATE pokemon
SET evolution_id = 1
WHERE id IN (1, 2, 3);

UPDATE pokemon
SET evolution_id = 2
WHERE id IN (4, 5, 6);

UPDATE pokemon
SET evolution_id = 3
WHERE id IN (7, 8, 9);

UPDATE pokemon
SET evolution_id = 4
WHERE id IN (10, 11, 12);

UPDATE pokemon
SET evolution_id = 5
WHERE id IN (13, 14, 15);

UPDATE pokemon
SET evolution_id = 6
WHERE id IN (16, 17, 18);

UPDATE pokemon
SET evolution_id = 7
WHERE id IN (19, 20, 21);