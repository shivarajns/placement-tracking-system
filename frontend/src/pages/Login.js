import{ useState } from "react";
import "../style/pages/Login.css"
import Logo from "../components/common/Logo";
import Button from "../components/common/button";
// import axios from "axios"
import { LoginUser } from "../services/authService";
import { useNavigate } from "react-router-dom";

function Login() {

    const [email, setEmail] = useState("");
    const [password, setPass] = useState("");
    const [message, setMessage] = useState("");
    // const [loading, setLoading] = useState(false);

    const navigate = useNavigate();

    // useEffect(() => {
    //     alert(message)
    // }, [message])

    const HandleLogin = async () => {
        try {
            const data = await LoginUser(email, password)
            setMessage(data.message)
            console.log("Login Success")
            console.log(message)

            if (data.role === "ADMIN") {
                navigate("/ADMIN")
            }
            else{
                navigate("/dashboard")
            }
        }
        catch (error){
            alert("login failed")
            console.log(error);
        }

        

    }





    return (
        <div className="login-page">
            <div className="login-logo">
                <Logo />
            </div>
            <div className="login-cnt">
                <h1>Login</h1>
                <p style={{ "marginTop": "5px" }}>User Email</p>

                <input type="email" id="UserLoginEmail" className="InputBoxes" placeholder="Example@gmail.com" required
                    onChange={(e) => { setEmail(e.target.value) }}
                ></input>

                <p style={{ "marginTop": "5px" }}>Password</p>

                <input type="password" id="UserLoginPass" className="InputBoxes" placeholder="Enter your Password" required
                    onChange={(e) => { setPass(e.target.value) }}
                ></input>

                {/* <label for="role" style={{ "marginTop": "5px" }}>Select Role</label>
                <select id="role" name="role" required> 
                    <option value="" disabled selected>role</option>
                    <option value="STUDENT">Student</option>
                    <option value="RECRUITER">Recruiter</option>
                    <option value="ADMIN">Admin</option>
                </select> */}
                <Button content="Login" onClick={HandleLogin}></Button>
            </div>
        </div>
    )
}

export default Login