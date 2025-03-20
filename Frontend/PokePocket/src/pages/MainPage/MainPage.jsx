import React from "react";
import "./MainPage.css";
import MyPokemonCard from "../../components/MainPageCards/MyPokemon/MyPokemonCard";
import MyPocketCard from "../../components/MainPageCards/MyPocket/MyPocketCard";
import {useNavigate} from "react-router-dom";

function MainPage() {
  const cardClasses = "cursor-pointer flex rounded-xl relative group h-60  bg-cover bg-center bg-hover-animate ";
  const navigate = useNavigate();
  return (
    <div className="w-full">
      <div className="flex">
        <div className=" bg-white basis-6/12 mx-auto h-20 mt-4 rounded-xl"></div>
      </div>
      <div className=" flex">
        <div className="grid grid-cols-2 gap-4 mx-auto h-40 mt-4 basis-6/12">
          <MyPokemonCard cardClasses={cardClasses} navigate={navigate}></MyPokemonCard>
          <MyPocketCard cardClasses={cardClasses} navigate={navigate}></MyPocketCard>
          <div className={cardClasses + " bg-error/50"}></div>
          <div className={cardClasses + " bg-success/50 h-60"}></div>
        </div>
      </div>
    </div>
  );
}

export default MainPage;
