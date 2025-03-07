import React from "react";
import { Navbar, Container, Nav, NavDropdown, NavLink } from "react-bootstrap";
import PokeBall from "../../assets/pokeball.png";
import "./CustomNavbar.css";
import { PersonCircle } from "react-bootstrap-icons";
import { Outlet } from "react-router-dom";

function CustomNavbar() {
  return (
    <>
      <Navbar
        expand="lg"
        className="bg-body-tertiary navbar rounded-pill my-2"
        style={{ height: "10%" }}
      >
        <Container>
          <Navbar.Brand href="#home">
            <img src={PokeBall} alt="" style={{ maxHeight: "50px" }} />
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto custom-nav font-bold font-serif ">
              <Nav.Link href="" className="mx-2 rounded-pill">
                Home
              </Nav.Link>
              <Nav.Link href="" className="mx-2 rounded-pill">
                Link
              </Nav.Link>
              <Nav.Link href="" className="mx-2 rounded-pill">
                Placeholder
              </Nav.Link>
              <PersonCircle size={30} className="ml-8 my-auto"></PersonCircle>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Container fluid
        className="bg-light col-8 !rounded rounded-pill"
        style={{ height: "60%", position:"absolute", top:"20%"}}
      >
        <Outlet></Outlet>
      </Container>
    </>
  );
}

export default CustomNavbar;
