import React from "react";
import { useState } from "react";
import "../style/pages/Register.css";
import Logo from "../components/common/Logo";
import { RegisterUser } from "../services/RegisterService";
import { useNavigate } from "react-router-dom";

function Register() {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
        role: "STUDENT"
    });

    const [message, setMessage] = useState("")
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    async function handleSubmit(e) {
        e.preventDefault(); 
        
        try {
            const result = await RegisterUser(formData)
            setMessage(result.message)
            alert(result.message)
            navigate("/login")
            
        } catch (error) {
            setMessage(error)
            alert(message)
            console.log("Error Message: ", message)
        }
    };

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


                    <input type="hidden" name="role" value="STUDENT" />

                    <button type="submit">Register</button>

                </form>
            </div>
        </div>
    );
}

export default Register