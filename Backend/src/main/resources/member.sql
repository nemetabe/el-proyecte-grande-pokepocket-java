-- Insert a member (user)
INSERT INTO member (id, name, email, password)
VALUES (1, 'Ash Ketchum', 'ash@pokemon.com', 'pikachu123');

-- -- Insert categories
-- INSERT INTO category (id, type, description) VALUES
--                                                  (1, 'INCOME', 'Money coming in from battles and tournaments'),
--                                                  (2, 'GROCERY', 'Pokémon food and berries'),
--                                                  (3, 'ENTERTAINMENT', 'Fun activities with Pokémon'),
--                                                  (4, 'TRANSPORTATION', 'Bikes and travel expenses'),
--                                                  (5, 'DINING_OUT', 'Eating at Pokémon Centers');

-- Insert one income transaction
INSERT INTO transaction (id, name, category_id, amount, member_id, date)
VALUES (1, 'Tournament Winnings', 1, 150000, 1, '2025-03-01');

-- Insert five expense transactions with different categories
INSERT INTO transaction (id, name, category_id, amount, member_id, date)
VALUES
    (2, 'Food Supply', 2, 12500, 1, '2025-03-05'),        -- GROCERY
    (3, 'Movie Tickets', 13, 3000, 1, '2025-03-08'),      -- ENTERTAINMENT
    (4, 'Bicycle Repair', 12, 5500, 1, '2025-03-10'),             -- TRANSPORTATION
    (5, 'Lunch at Celadon City', 11, 4700, 1, '2025-03-15'),      -- DINING_OUT
    (6, 'Potion and Revival Herbs', 6, 9800, 1, '2025-03-20');    -- PETS

-- Set up evolution chains (if not already present)
INSERT INTO evolution_chains (id, base_pokemon_id, evolved_pokemon_id, evolution_trigger, min_happiness, evolution_chain_id)
VALUES
    (
        1,
        (SELECT id FROM pokemon_species WHERE poke_index_number = 172), -- Pichu
        (SELECT id FROM pokemon_species WHERE poke_index_number = 25),  -- Pikachu
        'happiness',
        220,
        10
    ),
    (
        2,
        (SELECT id FROM pokemon_species WHERE poke_index_number = 25),  -- Pikachu
        (SELECT id FROM pokemon_species WHERE poke_index_number = 26),  -- Raichu
        'happiness',
        220,
     10
    ),(
        3,
        (SELECT id FROM pokemon_species WHERE poke_index_number = 26),  -- Pikachu
        null,
        'happiness',
        220,
       10
    )
;

-- Insert a Pikachu for Ash
INSERT INTO user_pokemon (id, species_id, user_id, nickname, happiness, picture_url, hatch_date, is_evolution_pending) --, gif_url
VALUES (
           1,
           (SELECT id FROM pokemon_species WHERE poke_index_number = 25), -- Pikachu
           1, -- Ash's user ID
           'Sparky',
           150, -- Happiness level - they're close but not ready to evolve
           (SELECT picture_url FROM pokemon_assets WHERE species_id = (SELECT id FROM pokemon_species WHERE poke_index_number = 25)),
--            (SELECT gif_url FROM pokemon_assets WHERE species_id = (SELECT id FROM pokemon_species WHERE poke_index_number = 25)),
           '2025-01-15 08:30:00', -- Hatched a couple months ago
           false
       );

-- Insert a saving goal for a PokéBall collection
INSERT INTO saving (id, member_id, start_date, end_date, target_amount, current_amount)
VALUES (1, 1, '2025-03-01', '2025-06-01', 75000.00, 25000.00);