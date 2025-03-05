import App from './App.jsx'
import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Registration from './pages/Registration.jsx';
import "./main.css"

const router = createBrowserRouter([
  {
    path: "/",
    element: <Registration></Registration>
  },
  // {
  //   path: "/main",
  //   element: <MainPage />,
  //   // errorElement: <ErrorPage />, future implement if have remaining time
  //   children: [
  //     {
  //       path: "/question/:id",
  //       element: <QuestionPage />
  //     },
  //     {
  //       path: "/user/:id/create-question",
  //       element: <QuestionForm/>
  //     },
  //     {
  //       path: "/login",
  //       element: <Login/>
  //     }
  //   ],
  // },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
