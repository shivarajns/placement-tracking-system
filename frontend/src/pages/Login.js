import React from "react";
import "../style/pages/Login.css"
import Logo from "../components/common/Logo";
import Button from "../components/common/button";

function Login() {

    return (
        <div className="login-page">
            <div className="login-logo">
                <Logo />
            </div>
            <div className="login-cnt">
                <h1>Login</h1>
                <p style={{ "marginTop": "5px" }}>User Email</p>
                <input type="Text" id="UserLoginEmail" className="InputBoxes" placeholder="Example@gmail.com"></input>
                <p style={{ "marginTop": "5px" }}>Password</p>
                <input type="Text" id="UserLoginPass" className="InputBoxes" placeholder="Enter your Password"></input>
                <label for="role" style={{ "marginTop": "5px" }}>Select Role</label>
                <select id="role" name="role">
                    <option value="" disabled selected>role</option>
                    <option value="student">Student</option>
                    <option value="recruiter">Recruiter</option>
                    <option value="admin">Admin</option>
                </select>
                <Button content="Login"></Button>
            </div>
        </div>
    )
}

export default Login