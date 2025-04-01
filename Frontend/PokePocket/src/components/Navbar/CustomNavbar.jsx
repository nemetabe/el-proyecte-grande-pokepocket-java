import React from "react";
import PokeBall from "../../assets/pokeball.png";
import "./CustomNavbar.css";
import { useNavigate, Link } from "react-router-dom";

function CustomNavbar() {
  const navigate = useNavigate();

  function onCLickLogout() {
    localStorage.setItem("pokePocketJwt", "null");

    navigate("/");
  }

  return (
    <>
      <div className="flex">
        <div className="navbar bg-white text-black shadow-sm flex basis-8/12 mx-auto mt-2 rounded-full align-items-center justify-center">
          <div className="navbar-start align-items-center">
            <div className="dropdown">
              <div
                tabIndex={0}
                role="button"
                className="btn btn-ghost lg:hidden"
              >
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
                  <a>Item 2</a>
                </li>
                <li>
                  <a>Item 3</a>
                </li>
              </ul>
            </div>
            <div href="#home" className="h-10">
              <button className="">
                <img src={PokeBall} alt="" className="w-10 m-auto" />
              </button>
            </div>
          </div>
          <div className="navbar-center hidden lg:flex">
            <ul className="menu menu-horizontal px-1 text-xl">
              <li>
                <a>Item 1</a>
              </li>
              <li>
                <a>Item 2</a>
              </li>
              <li>
                <a>Item 3</a>
              </li>
            </ul>
          </div>
          <div className="navbar-end avatar">
            <div className="dropdown dropdown-end">
              <button
                className="w-10 h-10 rounded-full overflow-hidden"
                popoverTarget="popover-1"
                style={{ anchorName: "--anchor-1" } }
              >
                  <img src="https://img.daisyui.com/images/stock/photo-1534528741775-53994a69daeb.webp" />
                
              </button>

              <ul
                className="dropdown menu rounded-box bg-base-100 shadow-sm"
                popover="auto"
                id="popover-1"
                style={
                  { positionAnchor: "--anchor-1" }
                }
              >
                <li>
                  <Link to={"/main/profile/edit"}>
                    <a>Edit Profile</a>
                  </Link>
                </li>
                <li>
                  <a onClick={() => onCLickLogout()}>Log out</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default CustomNavbar;
