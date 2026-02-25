import React from "react";
import { logoutUser } from "../services/authService";
import { Navigate, useNavigate } from "react-router-dom";

function Dashboard(){

const navigate = useNavigate();

    const handleLogOut = ()=> {
        logoutUser()
        navigate("/login")
    }


    return(
        <div className="Dashboard">
            <h1>Welcome to Dashboard</h1>
            <button onClick={handleLogOut}>Logout</button>
        </div>
    )

}

export default Dashboard