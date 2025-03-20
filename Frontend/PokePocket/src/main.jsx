import App from './App.jsx'
import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Registration from './pages/Registration/Registration.jsx';
import "./main.css"
import CustomNavbar from './components/Navbar/CustomNavbar.jsx';
import ErrorPage from './pages/Errorpage/ErrorPage.jsx';
import MainPage from './pages/MainPage/MainPage.jsx';
import MyPokemon from './pages/MyPokemon/MyPokemon.jsx';
import MyPocket from './pages/MyPocket/MyPocket.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Registration />
  },
  {
    path: "/main",
    element: <CustomNavbar />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/main",
        element: <MainPage />
      },
      {
        path: "/main/mypokemon",
        element: <MyPokemon/>
      },
      {
        path: "/main/mypocket",
        element: <MyPocket/>
      }
    ],
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
