import { useEffect, useState } from "react";
import CustomNavbar from "../components/Navbar/CustomNavbar";
import { Outlet, useNavigate } from "react-router-dom";

function Layout() {
    const navigate = useNavigate();

    useEffect(() => {
        localStorage.getItem("pokePocketJwt") == "null" && navigate("/");
    }, []);

    return (
        <>
            <CustomNavbar />
            <Outlet />
        </>
    );
}

export default Layout;
