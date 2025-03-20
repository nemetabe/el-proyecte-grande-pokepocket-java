import React from 'react'
import pikachu from "../../../assets/pikachu.png";
import "./MyPocketCard.css"

function MyPocketCard({cardClasses, navigate}) {
  return (
        <div
        onClick={() => navigate("/main/mypocket")}
        className={
          cardClasses + " bg-warning/50 lightning"
        }
        style={{ backgroundImage: `url(${pikachu})` }}
      >
        <div className="absolute inset-0  opacity-0"></div>
        <div className="text-black bg-white/80 font-[1000] text-center p-5 w-[50%] h-[25%] m-auto z-1 text-xl rounded-full pika">
          <h1>My Pocket</h1>
        </div>
      </div>
  )
}

export default MyPocketCard