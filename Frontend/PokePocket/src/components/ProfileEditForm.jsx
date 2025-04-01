
function ProfileEditForm({ handleChange, handleSubmit, formData, validation, navigate }) {
    return (
        <form className="p-5" onSubmit={handleSubmit}>
            {/* Username */}
            <fieldset className='fieldset'>
                <div className='flex-row'>
                    <label htmlFor="username" className="font-medium text-[1rem] flex">
                        Username
                    </label>
                    <input
                        type="text"
                        className={`input ${
                            validation.username
                                ? validation.username === "Correct"
                                    ? "input-success"
                                    : "input-error"
                                : ""
                        }`}
                        id="username"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                    {validation.username && (
                        <small
                            className={`text-[14px] flex  
                ${validation.username === "Correct"
                                ? "text-success"
                                : "text-error"}  
                `
                            }
                        >
                            {validation.username}
                        </small>
                    )}
                </div>
            </fieldset>

            {/* Email */}
            <fieldset className='fieldset'>
                <label htmlFor="email" className="font-medium text-[1rem]">
                    Email
                </label>
                <input
                    type="email"
                    className={`input ${
                        validation.email
                            ? validation.email === "Correct"
                                ? "input-success"
                                : "input-error"
                            : ""
                    }`}
                    id="email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                />
                {validation.email && (
                    <small
                        className={`text-[14px]  
              ${validation.email === "Correct"
                            ? "text-success"
                            : "text-error"}  
              `
                        }
                    >
                        {validation.email}
                    </small>
                )}
            </fieldset>

            {/* Password Change Section */}
            <div className="border-t border-gray-200 mt-4 pt-4">
                <h3 className="font-semibold text-lg mb-3">Change Password (Optional)</h3>

                {/* Current Password */}
                <fieldset className='fieldset'>
                    <label htmlFor="password" className="font-medium text-[1rem]">
                        Current Password
                    </label>
                    <input
                        type="password"
                        className="input"
                        id="password"
                        value={formData.password}
                        onChange={handleChange}
                    />
                </fieldset>

                {/* New Password */}
                <fieldset className='fieldset'>
                    <label htmlFor="newPassword" className="font-medium text-[1rem]">
                        New Password
                    </label>
                    <input
                        type="password"
                        className={`input ${
                            validation.newPassword
                                ? validation.newPassword === "Correct"
                                    ? "input-success"
                                    : "input-error"
                                : ""
                        }`}
                        id="newPassword"
                        value={formData.newPassword}
                        onChange={handleChange}
                    />
                    {validation.newPassword && (
                        <small
                            className={`text-[14px]  
                ${validation.newPassword === "Correct"
                                ? "text-success"
                                : "text-error"}  
                `
                            }
                        >
                            {validation.newPassword}
                        </small>
                    )}
                </fieldset>

                {/* Confirm New Password */}
                <fieldset className='fieldset'>
                    <label htmlFor="confirmPassword" className="font-medium text-[1rem]">
                        Confirm New Password
                    </label>
                    <input
                        type="password"
                        className={`input ${
                            validation.confirmPassword
                                ? validation.confirmPassword === "Correct"
                                    ? "input-success"
                                    : "input-error"
                                : ""
                        }`}
                        id="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                    />
                    {validation.confirmPassword && (
                        <small
                            className={`text-[14px]  
                ${validation.confirmPassword === "Correct"
                                ? "text-success"
                                : "text-error"}  
                `
                            }
                        >
                            {validation.confirmPassword}
                        </small>
                    )}
                </fieldset>
            </div>

            {/* Buttons */}
            <div className="flex justify-between mt-6">
                <button
                    type="button"
                    className="btn btn-outline"
                    onClick={() => navigate("/main")}
                >
                    Cancel
                </button>
                <button
                    className="btn btn-primary rounded-full"
                    type="submit"
                >
                    Save Changes
                </button>
            </div>
        </form>
    );
}

export default ProfileEditForm;