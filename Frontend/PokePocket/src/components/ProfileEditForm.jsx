
import React from "react";

function ProfileEditForm({
                             handleChange,
                             handleSubmit,
                             formData,
                             validation,
                             navigate,
                             emailReadOnly = false // New prop with default value
                         }) {
    return (
        <form onSubmit={handleSubmit} className="space-y-4">
            <div className="form-control">
                <label htmlFor="username" className="label">
                    <span className="label-text font-semibold">Username</span>
                </label>
                <input
                    type="text"
                    id="username"
                    className={`input input-bordered w-full ${
                        validation.username === "Correct"
                            ? "input-success"
                            : validation.username
                                ? "input-error"
                                : ""
                    }`}
                    value={formData.username}
                    onChange={handleChange}
                    required
                />
                {validation.username && validation.username !== "Correct" && (
                    <p className="text-red-500 text-sm mt-1">{validation.username}</p>
                )}
            </div>

            <div className="form-control">
                <label htmlFor="email" className="label">
                    <span className="label-text font-semibold">Email {emailReadOnly && "(Read-only)"}</span>
                </label>
                <input
                    type="email"
                    id="email"
                    className="input input-bordered w-full bg-gray-100"
                    value={formData.email}
                    onChange={handleChange}
                    readOnly={emailReadOnly}
                    disabled={emailReadOnly}
                    required
                />
            </div>

            <div className="form-control">
                <label htmlFor="password" className="label">
                    <span className="label-text font-semibold">Current Password (required for changes)</span>
                </label>
                <input
                    type="password"
                    id="password"
                    className="input input-bordered w-full"
                    value={formData.password}
                    onChange={handleChange}
                />
            </div>

            <div className="form-control">
                <label htmlFor="newPassword" className="label">
                    <span className="label-text font-semibold">New Password (optional)</span>
                </label>
                <input
                    type="password"
                    id="newPassword"
                    className={`input input-bordered w-full ${
                        validation.newPassword === "Correct"
                            ? "input-success"
                            : validation.newPassword
                                ? "input-error"
                                : ""
                    }`}
                    value={formData.newPassword}
                    onChange={handleChange}
                />
                {validation.newPassword && validation.newPassword !== "Correct" && (
                    <p className="text-red-500 text-sm mt-1">{validation.newPassword}</p>
                )}
            </div>

            <div className="form-control">
                <label htmlFor="confirmPassword" className="label">
                    <span className="label-text font-semibold">Confirm New Password</span>
                </label>
                <input
                    type="password"
                    id="confirmPassword"
                    className={`input input-bordered w-full ${
                        validation.confirmPassword === "Correct"
                            ? "input-success"
                            : validation.confirmPassword
                                ? "input-error"
                                : ""
                    }`}
                    value={formData.confirmPassword}
                    onChange={handleChange}
                />
                {validation.confirmPassword && validation.confirmPassword !== "Correct" && (
                    <p className="text-red-500 text-sm mt-1">{validation.confirmPassword}</p>
                )}
            </div>

            <div className="flex justify-between mt-6">
                <button
                    type="button"
                    className="btn btn-outline"
                    onClick={() => navigate("/main")}
                >
                    Cancel
                </button>
                <button type="submit" className="btn btn-primary">Save Changes</button>
            </div>
        </form>
    );
}

export default ProfileEditForm;
