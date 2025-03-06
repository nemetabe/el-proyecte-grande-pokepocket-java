import React from "react";
import { Navbar, Container, Nav, NavDropdown } from "react-bootstrap";
import PokeBall from "../../assets/pokeball.png";
import "./CustomNavbar.css";

function CustomNavbar() {
  return (
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
          <Nav className="me-auto custom-nav font-bold font-serif">
            <Nav.Link href="#home" className="mx-2 rounded-pill">
              Home
            </Nav.Link>
            <Nav.Link href="" className="mx-2 rounded-pill">
              Link
            </Nav.Link>
            <Nav.Link href="" className="mx-2 rounded-pill">
              Placeholder
            </Nav.Link>
            <Nav.Link href="" className="mx-2 rounded-pill d-flex">
              <img src="" alt="" />
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default CustomNavbar;
