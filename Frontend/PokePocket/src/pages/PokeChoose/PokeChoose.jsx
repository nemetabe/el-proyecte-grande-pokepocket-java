import React, { useState, useEffect } from 'react'
import { ChevronLeft, ChevronRight } from 'lucide-react';
import { fetchData } from '../../utils';
import { useNavigate } from 'react-router-dom';

function PokeChoose() {
    const [pokemons, setPokemons] = useState(null);
    const [current, setCurrent] = useState(0);
    const [showChoose, setShowChoose] = useState(false);
    const [chosenPokemon, setChosenPokemon] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchData("pokemon/all", "GET", null, localStorage.getItem("pokePocketJwt")).then(data => {
            setPokemons(data);
        });
    }, []);

    const prev = () => {
        setCurrent((prev) => (prev === 0 ? pokemons.length - 1 : prev - 1));
        setShowChoose(false);
    };
    const next = () => {
        setCurrent((prev) => (prev === pokemons.length - 1 ? 0 : prev + 1));
        setShowChoose(false);
    };

    const handleImgClick = () => {
        setShowChoose(true);
    };

    const handleChoose = () => {
        setChosenPokemon(pokemons[current]);
        fetchData("user/choose", "POST", pokemons[current].id , localStorage.getItem("pokePocketJwt")).then(data => {
            console.log(data);
            navigate("/main");
        }
        )
        setShowChoose(false);
    };

    if (!pokemons) {
        return <div>Loading...</div>;
    }

    return (
        <div className="min-h-screen flex items-center justify-center">
            <div className="bg-orange-50 p-10 rounded-xl min-w-[800px] min-h-[500px] relative shadow-lg">
                <div className="absolute top-6 left-1/2 -translate-x-1/2 text-3xl font-bold text-orange-500 select-none">Choose Pokémon</div>
                <button
                    onClick={prev}
                    className="absolute left-2 top-1/2 -translate-y-1/2 bg-orange-200 hover:bg-orange-300 text-2xl rounded-full w-10 h-10 flex items-center justify-center shadow"
                >
                    <ChevronLeft size={28} />
                </button>
                <div className="flex items-center justify-center gap-10">
                    <img
                        src={pokemons[(current - 1 + pokemons.length) % pokemons.length].img}
                        alt="prev"
                        className="w-32 opacity-50 transition-all duration-300 cursor-pointer"
                        style={{ imageRendering: 'pixelated' }}
                        onClick={handleImgClick}
                    />
                    <div className="text-center">
                        <img
                            src={pokemons[current].img}
                            alt={pokemons[current].name}
                            className="w-64 mx-auto drop-shadow-lg transition-all duration-300 cursor-pointer"
                            style={{ imageRendering: 'pixelated' }}
                            onClick={handleImgClick}
                        />
                        <div className="font-bold text-2xl mt-2 text-orange-700">
                            {pokemons[current].name}
                        </div>
                    </div>
                    <img
                        src={pokemons[(current + 1) % pokemons.length].img}
                        alt="next"
                        className="w-32 opacity-50 transition-all duration-300 cursor-pointer"
                        style={{ imageRendering: 'pixelated' }}
                        onClick={handleImgClick}
                    />
                </div>
                <button
                    onClick={next}
                    className="absolute right-2 top-1/2 -translate-y-1/2 bg-orange-200 hover:bg-orange-300 text-2xl rounded-full w-10 h-10 flex items-center justify-center shadow"
                >
                    <ChevronRight size={28} />
                </button>
                <div className="flex justify-center mt-8 gap-3">
                    {pokemons.map((_, idx) => (
                        <span
                            key={idx}
                            className={`w-3 h-3 rounded-full inline-block transition-all duration-300 ${idx === current ? 'bg-orange-400 scale-125' : 'bg-orange-200'}`}
                        ></span>
                    ))}
                </div>
                {showChoose && (
                    <div className="flex justify-center mt-8">
                        <button
                            onClick={handleChoose}
                            className="bg-orange-400 hover:bg-orange-500 text-white font-bold py-2 px-6 rounded-lg shadow transition-all duration-200"
                        >
                            Choose
                        </button>
                    </div>
                )}
                {chosenPokemon && (
                    <div className="flex justify-center mt-4 text-lg text-orange-700 font-semibold">
                        Chosen: {chosenPokemon.name}
                    </div>
                )}
            </div>
        </div>
    )
}

export default PokeChoose