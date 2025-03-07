import React from 'react'

const PokeBall = new URL('../../assets/pokeball.png', import.meta.url).href;

function ErrorPage() {
  return (
    <div className='d-flex justify-content-center my-auto' style={{height:"100%"}}>
        <div className='text-secondary my-auto text-[100px]'>4</div>
        <img src={PokeBall} alt="PokeBall"  className='my-auto' style={{maxHeight:"100px"}}/>
        <div className='text-secondary my-auto text-[100px]'>4</div>
    </div>
  )
}

export default ErrorPage
