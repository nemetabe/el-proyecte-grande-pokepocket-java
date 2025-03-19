import React from "react";
import PokeBall from "../../assets/pokeball.png";
import "./CustomNavbar.css";
import { Outlet } from "react-router-dom";

function CustomNavbar() {
  return (
    <>
      {/* <div
        className="bg-white flex rounded-pill my-2 h-[10%]"
      >
        <div>
          <div href="#home">
            <img src={PokeBall} alt="" style={{ maxHeight: "50px" }} />
          </div>
          <div aria-controls="basic-navbar-nav" />
          <div id="basic-navbar-nav">
            <div className="me-auto custom-nav font-bold font-serif ">
              <div href="" className="mx-2 rounded-pill">
                Home
              </div>
              <div href="" className="mx-2 rounded-pill">
                Link
              </div>
              <div href="" className="mx-2 rounded-pill">
                Placeholder
              </div>
              <div size={30} className="ml-8 my-auto"></div>
            </div>
          </div>
        </div>
      </div> */}
      <div className="navbar bg-base-200 shadow-sm flex">
        <div className="navbar-start">
          <div className="dropdown">
            <div tabIndex={0} role="button" className="btn btn-ghost lg:hidden">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-5 w-5"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                {" "}
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth="2"
                  d="M4 6h16M4 12h8m-8 6h16"
                />{" "}
              </svg>
            </div>
            <ul
              tabIndex={0}
              className="menu menu-sm dropdown-content bg-base-100 rounded-box z-1 mt-3 w-52 p-2 shadow"
            >
              <li>
                <a>Item 1</a>
              </li>
              <li>
                <a>Parent</a>
                <ul className="p-2">
                  <li>
                    <a>Submenu 1</a>
                  </li>
                  <li>
                    <a>Submenu 2</a>
                  </li>
                </ul>
              </li>
              <li>
                <a>Item 3</a>
              </li>
            </ul>
          </div>
          <div href="#home">
            <button className="">
              <img src={PokeBall} alt="" className="w-10" />
            </button>
          </div>
        </div>
        <div className="navbar-center hidden lg:flex">
          <ul className="menu menu-horizontal px-1 text-xl">
            <li>
              <a >Item 1</a>
            </li>
            <li>
              <details>
                <summary>Parent</summary>
                <ul className="p-2">
                  <li>
                    <a>Submenu 1</a>
                  </li>
                  <li>
                    <a>Submenu 2</a>
                  </li>
                </ul>
              </details>
            </li>
            <li>
              <a>Item 3</a>
            </li>
          </ul>
        </div>
        <div className="navbar-end avatar">
          <div className="w-10 rounded-full">
            <img src="https://img.daisyui.com/images/stock/photo-1534528741775-53994a69daeb.webp" />
          </div>
        </div>
      </div>
      <Outlet />
    </>
  );
}

export default CustomNavbar;
