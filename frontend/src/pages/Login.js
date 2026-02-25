import { useState, useEffect } from "react";
import "../style/pages/Login.css";
import Logo from "../components/common/Logo";
import Button from "../components/common/button";
import { LoginUser, saveToken } from "../services/authService";
import { useNavigate } from "react-router-dom";

function Login() {

    const [email, setEmail] = useState("");
    const [password, setPass] = useState("");
    const [message, setMessage] = useState("");

    const navigate = useNavigate();


    function parseJwt(token) {
        try {
            return JSON.parse(atob(token.split(".")[1]));
        } catch {
            return null;
        }
    }


    function isTokenExpired(token) {
        if (!token) return true;

        const decoded = parseJwt(token);
        if (!decoded?.exp) return true;

        const currentTime = Date.now() / 1000;
        return decoded.exp < currentTime;
    }


    useEffect(() => {
        const token = localStorage.getItem("token");

        if (token && !isTokenExpired(token)) {
            navigate("/dashboard");
        } else {
            localStorage.removeItem("token");
        }
    }, [navigate]);


    const HandleLogin = async () => {
        try {
            const data = await LoginUser(email, password);

            setMessage(data.message);
            console.log("Login Success");

            saveToken(data.token);


            if (data.role === "ADMIN") {
                navigate("/ADMIN");
            } else {
                navigate("/dashboard");
            }

        } catch (error) {
            alert("Login failed");
            console.log(error);
        }
    };

    return (
        <div className="login-page">

            <div className="login-logo">
                <Logo />
            </div>

            <div className="login-cnt">
                <h1>Login</h1>

                <p style={{ marginTop: "5px" }}>User Email</p>
                <input
                    type="email"
                    className="InputBoxes"
                    placeholder="Example@gmail.com"
                    required
                    onChange={(e) => setEmail(e.target.value)}
                />

                <p style={{ marginTop: "5px" }}>Password</p>
                <input
                    type="password"
                    className="InputBoxes"
                    placeholder="Enter your Password"
                    required
                    onChange={(e) => setPass(e.target.value)}
                />

                <Button content="Login" onClick={HandleLogin} />

                {message && <p>{message}</p>}
            </div>

        </div>
    );
}

export default Login;