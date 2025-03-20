INSERT INTO pokemon_species (poke_index_number, name, description, base_happiness, evolution_trigger,
                             evolution_threshold)
VALUES
-- ============= CUTE 3-STAGE EVOLUTION POKÉMON =============
-- Pichu -> Pikachu -> Raichu (3-stage)
(172, 'Pichu', 'It is still inept at storing electricity. It may send out a jolt if amused or startled.', 70,
 'happiness', 220),
(25, 'Pikachu', 'When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.', 70,
 'happiness', 220),
(26, 'Raichu',
 'Its electric charges can reach even 100,000 volts. Careless contact can cause even an Indian elephant to faint.', 70,
 NULL, NULL),

-- Togepi -> Togetic -> Togekiss (3-stage)
(175, 'Togepi', 'A proverb claims that happiness will come to anyone who can make a sleeping Togepi stand up.', 70,
 'happiness', 220),
(176, 'Togetic', 'They say that it will appear before kindhearted, caring people and shower them with happiness.', 70,
 'happiness', 220),
(468, 'Togekiss', 'It shares many blessings with people who respect one another''s rights and avoid needless strife.',
 70, NULL, NULL),

-- Cleffa -> Clefairy -> Clefable (3-stage)
(173, 'Cleffa', 'Because of its unusual, star-like silhouette, people believe that it came here on a meteor.', 70,
 'happiness', 220),
(35, 'Clefairy',
 'The moonlight that it stores in the wings on its back apparently gives it the ability to float in midair.', 70,
 'happiness', 220),
(36, 'Clefable', 'With its acute hearing, it can pick up sounds from far away. It usually hides in quiet places.', 70,
 NULL, NULL),

-- Igglybuff -> Jigglypuff -> Wigglytuff (3-stage)
(174, 'Igglybuff',
 'Its soft and bouncy body is very sensitive. It will begin bouncing and crying at the slightest touch.', 70,
 'happiness', 220),
(39, 'Jigglypuff', 'When its huge eyes waver, it sings a mysteriously soothing melody that lulls its enemies to sleep.',
 70, 'happiness', 220),
(40, 'Wigglytuff', 'The more air it takes in, the more it inflates. If it inhales deeply, it can float like a balloon.',
 70, NULL, NULL),

-- Mareep -> Flaaffy -> Ampharos (3-stage)
(179, 'Mareep',
 'Its fluffy wool rubs together fiat builds a static charge. The more energy is charged, the more brightly the lightbulb at the tip of its tail glows.',
 70, 'happiness', 220),
(180, 'Flaaffy',
 'Its fleece quality changes according to the season. The more static electricity is charged, the more brightly its lightbulb shines.',
 70, 'happiness', 220),
(181, 'Ampharos',
 'The bright light on its tail can be seen far away. It has been treasured since ancient times as a beacon.', 70, NULL,
 NULL),

-- Azurill -> Marill -> Azumarill (3-stage)
(298, 'Azurill', 'Its tail is large and bouncy. It is impossible to walk quietly after one.', 70, 'happiness', 220),
(183, 'Marill',
 'The oil-filled end of its tail floats on water. It keeps Marill from drowning even in a strong current.', 70,
 'happiness', 220),
(184, 'Azumarill',
 'It lives in rivers and lakes. It is used to life in water. It marks its territory by inflating the flotation sac on its body and making a sound wave.',
 70, NULL, NULL),

-- Budew -> Roselia -> Roserade (3-stage)
(406, 'Budew',
 'When it feels the sun is warm touch, it opens its bud to release pollen. It lives alongside clear pools.', 70,
 'happiness', 220),
(315, 'Roselia',
 'Roselia that drink nutritionally rich springwater are said to reveal rare coloration when they bloom.', 70,
 'happiness', 220),
(407, 'Roserade', 'It attracts prey with a sweet aroma, then downs it with thorny whips hidden in its arms.', 70, NULL,
 NULL),

-- Happiny -> Chansey -> Blissey (3-stage)
(440, 'Happiny',
 'It loves round white things. It carries a round stone in its pouch that looks like an egg, and gives it to others.',
 70, 'happiness', 220),
(113, 'Chansey', 'A kindly Pokémon that lays highly nutritious eggs and shares them with injured Pokémon or people.',
 70, 'happiness', 220),
(242, 'Blissey', 'The eggs it lays are filled with happiness. Eating even one bite will bring a smile to anyone.', 70,
 NULL, NULL),

-- Riolu -> Lucario (2-stage evolution)
(447, 'Riolu', 'It has the peculiar power of being able to see emotions such as joy and rage in the form of waves.', 70,
 'happiness', 220),
(448, 'Lucario', 'By catching the aura emanating from others, it can read their thoughts and movements.', 70, NULL,
 NULL),

-- ============= REGULAR 3-STAGE EVOLUTION POKÉMON =============
-- Charmander -> Charmeleon -> Charizard (3-stage)
(4, 'Charmander',
 'From the time it is born, a flame burns at the tip of its tail. Its life would end if the flame were to go out.', 70,
 'happiness', 220),
(5, 'Charmeleon', 'If it becomes agitated during battle, it spouts intense flames, incinerating its surroundings.', 70,
 'happiness', 220),
(6, 'Charizard', 'It is said that Charizard''s fire burns hotter if it has experienced harsh battles.', 70, NULL, NULL),

-- Bulbasaur -> Ivysaur -> Venusaur (3-stage)
(1, 'Bulbasaur',
 'There is a plant seed on its back right from the day this Pokémon is born. The seed slowly grows larger.', 70,
 'happiness', 220),
(2, 'Ivysaur', 'When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.', 70,
 'happiness', 220),
(3, 'Venusaur', 'Its plant blooms when it is absorbing solar energy. It stays on the move to seek sunlight.', 70, NULL,
 NULL),

-- Squirtle -> Wartortle -> Blastoise (3-stage)
(7, 'Squirtle', 'When it retracts its long neck into its shell, it squirts out water with vigorous force.', 70,
 'happiness', 220),
(8, 'Wartortle', 'It is recognized as a symbol of longevity. If its shell has algae on it, that Wartortle is very old.',
 70, 'happiness', 220),
(9, 'Blastoise',
 'It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw inside its shell.', 70, NULL,
 NULL),

-- Dratini -> Dragonair -> Dragonite (3-stage)
(147, 'Dratini', 'Long considered a mythical Pokémon until recently, when a small colony was found living underwater.',
 70, 'happiness', 220),
(148, 'Dragonair', 'They say that if it emits an aura from its whole body, the weather will begin to change instantly.',
 70, 'happiness', 220),
(149, 'Dragonite', 'It is said to make its home somewhere in the sea. It guides crews of shipwrecks to shore.', 70,
 NULL, NULL),

-- Beldum -> Metang -> Metagross (3-stage)
(374, 'Beldum',
 'Instead of blood, a powerful magnetic force courses throughout Beldum''s body. This Pokémon communicates with others by sending controlled pulses of magnetism.',
 70, 'happiness', 220),
(375, 'Metang',
 'When two Beldum fuse together, Metang is formed. The brains of the Beldum are joined by a magnetic nervous system.',
 70, 'happiness', 220),
(376, 'Metagross',
 'Metagross has four brains in total. Combined, the four brains can breeze through difficult calculations faster than a supercomputer.',
 70, NULL, NULL),

-- Bagon -> Shelgon -> Salamence (3-stage)
(371, 'Bagon',
 'Bagon has a dream of one day soaring in the sky. In doomed efforts to fly, this Pokémon hurls itself off cliffs.', 70,
 'happiness', 220),
(372, 'Shelgon',
 'Inside Shelgon''s armor-like shell, cells are in the midst of transformation to create an entirely new body.', 70,
 'happiness', 220),
(373, 'Salamence', 'After many long years, its cellular structure underwent a sudden mutation to grow wings.', 70, NULL,
 NULL),

-- Larvitar -> Pupitar -> Tyranitar (3-stage)
(246, 'Larvitar',
 'Born deep underground, it comes aboveground and becomes a pupa once it has finished eating the surrounding soil.', 70,
 'happiness', 220),
(247, 'Pupitar', 'Even sealed in its shell, it can move freely. Hard and fast, it has outstanding destructive power.',
 70, 'happiness', 220),
(248, 'Tyranitar',
 'The quakes caused when it walks make even great mountains crumble and change the surrounding terrain.', 70, NULL,
 NULL),

-- Gible -> Gabite -> Garchomp (3-stage)
(443, 'Gible', 'It nests in small, horizontal holes in cave walls. It pounces to catch prey that stray too close.', 70,
 'happiness', 220),
(444, 'Gabite', 'There is a long-held belief that medicine made from its scales will heal even incurable illnesses.',
 70, 'happiness', 220),
(445, 'Garchomp', 'It flies at speeds equal to a jet fighter plane. It never allows its prey to escape.', 70, NULL,
 NULL),

-- Machop -> Machoke -> Machamp (3-stage)
(66, 'Machop',
 'Its whole body is composed of muscles. Even though it''s the size of a human child, it can hurl 100 grown-ups.', 70,
 'happiness', 220),
(67, 'Machoke', 'Its muscular body is so powerful, it must wear a power-save belt to be able to regulate its motions.',
 70, 'happiness', 220),
(68, 'Machamp',
 'It quickly swings its four arms to rock its opponents with ceaseless punches and chops from all angles.', 70, NULL,
 NULL);