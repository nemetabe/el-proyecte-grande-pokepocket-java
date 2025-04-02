import React, {useState, useEffect} from "react";
import {useNavigate} from "react-router-dom";
import {fetchData} from "../../utils.js";
import "./ProfileEdit.css";
import ProfileEditForm from "../../components/ProfileEditForm.jsx";

function ProfileEdit() {

    const navigate = useNavigate();
    const [jwt, setJwt] = useState(localStorage.getItem("pokePocketJwt"));
    const [isLoading, setIsLoading] = useState(true);

    const [formData, setFormData] = useState({
        username: "",
        email: "",
        password: "",
        newPassword: "",
        confirmPassword: "",
    });

    const [validation, setValidation] = useState({
        username: "",
        email: "",
        newPassword: "",
        confirmPassword: "",
    });

    useEffect(() => {
        if (jwt === "null") {
            navigate("/");
            return;
        }

        const fetchUserProfile = async () => {
            try {
                const userData = await fetchData("user/profile", "GET", null, jwt);
                setFormData(prevData => ({
                    ...prevData,
                    username: userData.username || "",
                    email: userData.email || "",
                }));
                setIsLoading(false);
            } catch (error) {
                console.error("Error fetching profile:", error);
                setIsLoading(false);
            }
        };

        fetchUserProfile();
    }, [jwt, navigate]);

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
        if (!value) return ""; // Empty is valid for unchanged password

        const hasUpperCase = /[A-Z]/.test(value);
        const hasLowerCase = /[a-z]/.test(value);
        const hasNumber = /\d/.test(value);
        const isLongEnough = value.length >= 8;

        if (!hasUpperCase || !hasLowerCase || !hasNumber || !isLongEnough) {
            return "Password must be at least 8 characters, include upper/lowercase and a number";
        }
        return "Correct";
    };

    const validateConfirmPassword = (value) => {
        if (formData.newPassword && value !== formData.newPassword) {
            return "Passwords do not match";
        }
        return formData.newPassword ? "Correct" : "";
    };

    const handleChange = (e) => {
        const {id, value} = e.target;

        setFormData(prev => ({
            ...prev,
            [id]: value,
        }));

        let validationMessage = "";
        if (id === "username") validationMessage = validateUsername(value);
        if (id === "email") validationMessage = validateEmail(value);
        if (id === "newPassword") {
            validationMessage = validatePassword(value);
            // Also validate confirm password when password changes
            const confirmValidation = validateConfirmPassword(formData.confirmPassword);
            setValidation(prev => ({
                ...prev,
                confirmPassword: confirmValidation,
            }));
        }
        if (id === "confirmPassword") validationMessage = validateConfirmPassword(value);

        setValidation(prev => ({
            ...prev,
            [id]: validationMessage,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Validate form before submission
        if (
            (validation.username && validation.username !== "Correct") ||
            (validation.email && validation.email !== "Correct") ||
            (validation.newPassword && validation.newPassword !== "Correct") ||
            (validation.confirmPassword && validation.confirmPassword !== "Correct")
        ) {
            alert("Please correct the errors before submitting.");
            return;
        }

        const updateData = {
            username: formData.username,
            email: formData.email,
        };

        if (formData.newPassword) {
            updateData.currentPassword = formData.password;
            updateData.newPassword = formData.newPassword;
        }

        try {
            const response = await fetchData("user/profile/update", "PUT", updateData, jwt);

            if (response.success) {
                alert("Profile updated successfully!");
                navigate("/main");
            } else {
                alert(response.message || "Failed to update profile.");
            }
        } catch (error) {
            console.error("Error updating profile:", error);
            alert("An error occurred while updating your profile.");
        }
    };

    if (isLoading) {
        return (
            <div className="flex justify-center items-center h-[80vh]">
                <span className="loading loading-spinner loading-lg text-pokeball"></span>
            </div>
        );
    }

    return (
        <div>
            <div className="bg-white/75 m-5 rounded-[15px] flex justify-center">
                <div className="bg-white m-2 rounded-xl shadow-md p-5 max-w-md w-full">
                    <h2 className="text-3xl font-bold text-center mb-6 text-pokeball">Edit Profile</h2>

                    {/* Using a modified version of RegistrationForm */}
                    <div className="form-container fade-in">
                        <ProfileEditForm
                            handleChange={handleChange}
                            handleSubmit={handleSubmit}
                            formData={formData}
                            validation={validation}
                            navigate={navigate}
                        />
                    </div>
                </div>
            </div>
        </div>
    )


}

export default ProfileEdit