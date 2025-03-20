import React from 'react'
import gyarados from "../../../assets/gyarados.png";
import "./MyPokemonCard.css"

function MyPokemonCard({cardClasses, navigate}) {
  return (
    <div
    onClick={() => navigate("/main/mypokemon")}
    className={
      cardClasses + " bg-info/50 water"
    }
    style={{ backgroundImage: `url(${gyarados})` }}
  >
    <div className="absolute inset-0  opacity-0"></div>
    <div className="text-black bg-white/80 font-[1000] text-center p-5 w-[50%] h-[25%] m-auto z-1 text-xl rounded-full gyara">
      <h1>My pokemon</h1>
    </div>
  </div>
  )
}

export default MyPokemonCard