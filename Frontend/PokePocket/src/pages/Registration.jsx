import React, { useState } from "react";
import "./Registration.css";
import { Col, Container, Row } from "react-bootstrap";
import { fetchData } from "../utils";

function Registration() {
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
  });

  const [validation, setValidation] = useState({
    username: "",
    email: "",
    password: "",
  });

  const [isTermsAccepted, setIsTermsAccepted] = useState(false);
  const [isRegistering, setIsRegistering] = useState(true);
  const [isFadingOut, setIsFadingOut] = useState(false);

  const validateUsername = (value) => {
    if (value.length < 4) {
      return "Username must be at least 4 characters";
    }
    return "Correct";
  };

  const validateEmail = (value) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(value)) {
      return "Invalid email format";
    }
    return "Correct";
  };

  const validatePassword = (value) => {
    const hasUpperCase = /[A-Z]/.test(value);
    const hasLowerCase = /[a-z]/.test(value);
    const hasNumber = /\d/.test(value);
    const isLongEnough = value.length >= 8;

    if (!hasUpperCase || !hasLowerCase || !hasNumber || !isLongEnough) {
      return "Password must be at least 8 characters, include upper/lowercase and a number";
    }
    return "Correct";
  };

  const handleChange = (e) => {
    const { id, value } = e.target;

    setFormData((prev) => ({
      ...prev,
      [id]: value,
    }));

    let validationMessage = "";
    if (id === "username") validationMessage = validateUsername(value);
    if (id === "email") validationMessage = validateEmail(value);
    if (id === "password") validationMessage = validatePassword(value);

    setValidation((prev) => ({
      ...prev,
      [id]: validationMessage,
    }));
  };

  const handleCheckboxChange = (e) => {
    setIsTermsAccepted(e.target.checked);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (
      validation.username !== "Correct" ||
      validation.email !== "Correct" ||
      validation.password !== "Correct"
    ) {
      alert("Please correct the errors before submitting.");
      return;
    }

    console.log("Submitted data:", formData);
    fetchData(isRegistering ? "user/register" : "user/login", "POST", formData);
  };

  const switchForm = () => {
    setIsFadingOut(true);
    setTimeout(() => {
      setIsRegistering((prev) => !prev);
      setIsFadingOut(false);
    }, 500);
  };

  return (
    <>
      <Container
        className="bg-light my-auto col-8 whitebox d-flex justify-content-between"
        style={{ height: "600px" }}
      >
        <Container
          className={`col-5 my-auto text-dark form-container ${
            isFadingOut ? "fade-out" : "fade-in"
          }`}
        >
          {isRegistering ? (
            <>
              <Row className="text-center">
                <Col>
                  <h2>Registration</h2>
                </Col>
              </Row>
              <Row>
                <form className="row g-3" onSubmit={handleSubmit}>
                  {/* Username */}
                  <div>
                    <label htmlFor="username" className="form-label">
                      Username
                    </label>
                    <input
                      type="text"
                      className={`form-control ${
                        validation.username
                          ? validation.username === "Correct"
                            ? "is-valid"
                            : "is-invalid"
                          : ""
                      }`}
                      id="username"
                      value={formData.username}
                      onChange={handleChange}
                      required
                    />
                    <small
                      className={
                        validation.username === "Correct"
                          ? "text-success"
                          : "text-danger"
                      }
                    >
                      {validation.username}
                    </small>
                  </div>

                  {/* Email */}
                  <div>
                    <label htmlFor="email" className="form-label">
                      Email
                    </label>
                    <input
                      type="email"
                      className={`form-control ${
                        validation.email
                          ? validation.email === "Correct"
                            ? "is-valid"
                            : "is-invalid"
                          : ""
                      }`}
                      id="email"
                      value={formData.email}
                      onChange={handleChange}
                      required
                    />
                    <small
                      className={
                        validation.email === "Correct"
                          ? "text-success"
                          : "text-danger"
                      }
                    >
                      {validation.email}
                    </small>
                  </div>

                  {/* Password */}
                  <div>
                    <label htmlFor="password" className="form-label">
                      Password
                    </label>
                    <input
                      type="password"
                      className={`form-control ${
                        validation.password
                          ? validation.password === "Correct"
                            ? "is-valid"
                            : "is-invalid"
                          : ""
                      }`}
                      id="password"
                      value={formData.password}
                      onChange={handleChange}
                      required
                    />
                    <small
                      className={
                        validation.password === "Correct"
                          ? "text-success"
                          : "text-danger"
                      }
                    >
                      {validation.password}
                    </small>
                  </div>

                  {/* Terms Checkbox */}
                  <div className="col-12">
                    <div className="form-check">
                      <input
                        className="form-check-input"
                        type="checkbox"
                        id="termsAccepted"
                        checked={isTermsAccepted}
                        onChange={handleCheckboxChange}
                      />
                      <label
                        className="form-check-label"
                        htmlFor="termsAccepted"
                      >
                        Agree to terms and conditions
                      </label>
                    </div>
                  </div>

                  {/* Submit Button */}
                  <div className="col-4 mx-auto">
                    <button
                      className="btn btn-primary"
                      type="submit"
                      disabled={!isTermsAccepted}
                    >
                      Registration
                    </button>
                  </div>
                </form>
                <Row>
                  <a
                    className="my-2 text-center mx-auto"
                    href="#"
                    onClick={switchForm}
                  >
                    Already have an account?
                  </a>
                </Row>
              </Row>
            </>
          ) : (
            <>
              <Row className="text-center">
                <Col>
                  <h2>Login</h2>
                </Col>
              </Row>
              <Row>
                <form className="row g-3" onSubmit={handleSubmit}>
                  <div>
                    <label htmlFor="email" className="form-label">
                      Email
                    </label>
                    <input
                      type="email"
                      className="form-control"
                      id="email"
                      value={formData.email}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div>
                    <label htmlFor="password" className="form-label">
                      Password
                    </label>
                    <input
                      type="password"
                      className="form-control"
                      id="password"
                      value={formData.password}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="col-4 mx-auto d-flex justify-content-center">
                    <button className="btn btn-primary" type="submit">
                      Login
                    </button>
                  </div>
                </form>
                <Row>
                  <a
                    className="my-2 text-center mx-auto"
                    href="#"
                    onClick={switchForm}
                  >
                    Don't have an account? Register
                  </a>
                </Row>
              </Row>
            </>
          )}
        </Container>
        <Row className="col-4 justify-content-end ">
        <img
          className=" regImgDiv me-0"
          src={new URL("../assets/registrationImg.jpg", import.meta.url).href}
          alt="Registration"
          style={{ height: "100%" }}
        />
      </Row>
      </Container>
    </>
  );
}

export default Registration;
