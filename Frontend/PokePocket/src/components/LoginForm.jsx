import React from 'react'

function LoginForm({handleChange, handleSubmit, formData, switchForm}) {
  return (
    <>
    <div className="text-center">
      <div>
        <h2>Login</h2>
      </div>
    </div>
    <div>
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
      <div>
        <a
          className="my-2 text-center mx-auto"
          href="#"
          onClick={switchForm}
        >
          Don't have an account? Register
        </a>
      </div>
    </div>
  </>
  )
}

export default LoginForm