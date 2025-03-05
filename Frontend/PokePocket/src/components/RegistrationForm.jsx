import React from 'react'
import { Row, Col } from 'react-bootstrap'

function RegistrationForm({handleChange, handleSubmit, formData, switchForm, validation, handleCheckboxChange, isTermsAccepted}) {

  return (
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
  )
}

export default RegistrationForm