import React from 'react'

const PokeBall = new URL('../../assets/pokeball.png', import.meta.url).href;

function ErrorPage() {
  return (
    <div className='flex justify-center my-auto h-full'>
        <div className='text-pokeball my-auto text-9xl'>4</div>
        <img src={PokeBall} alt="PokeBall"  className='m-auto max-h-28'/>
        <div className='text-pokeball my-auto text-9xl'>4</div>
    </div>
  )
}

export default ErrorPage
