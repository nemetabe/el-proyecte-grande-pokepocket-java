import App from './App.jsx'
import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Registration from './pages/Registration/Registration.jsx';
import "./main.css"
import CustomNavbar from './components/Navbar/CustomNavbar.jsx';
import ErrorPage from './pages/Errorpage/ErrorPage.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Registration></Registration>
  },
  {
    path: "/main",
    element: <CustomNavbar />,
    // errorElement: <ErrorPage />, future implement if have remaining time
    children: [
      {
        path: "/main",
        element: <ErrorPage />
      },
  //     {
  //       path: "/user/:id/create-question",
  //       element: <QuestionForm/>
  //     },
  //     {
  //       path: "/login",
  //       element: <Login/>
  //     }
    ],
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
