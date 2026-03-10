import { useState } from "react";
import "../style/pages/Register.css";
import Logo from "../components/common/Logo";
import { RegisterUser } from "../services/RegisterService";
import { useNavigate } from "react-router-dom";

function RecruiterRegister() {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        role: "RECRUITER"
    });

    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    async function handleSubmit(e) {
        e.preventDefault(); // Prevent form reload
        try {
            const response = await RegisterUser(formData);
            alert(response?.message);
            console.log("register success");
            navigate("/login");
        } catch (error) {
            console.log("error", error);
        }
    }

    return (
        <div className="register-page">
            <div className="login-logo">
                <Logo />
            </div>
            <div className="register-card">
                <h2>Create Account</h2>

                <form onSubmit={handleSubmit}>
                    <label>Name</label>
                    <input
                        type="text"
                        name="name"
                        placeholder="Enter your name"
                        required
                        onChange={handleChange}
                    />

                    <label>Email</label>
                    <input
                        type="email"
                        name="email"
                        placeholder="Enter your email"
                        required
                        onChange={handleChange}
                    />

                    <label>Password</label>
                    <input
                        type="password"
                        name="password"
                        placeholder="Enter password"
                        required
                        onChange={handleChange}
                    />

                    <button type="submit">Register as Recruiter</button>
                </form>
            </div>        
        </div>
    );
}

export default RecruiterRegister;