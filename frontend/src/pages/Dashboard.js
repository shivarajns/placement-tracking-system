import React, { useEffect, useState } from "react";
import { logoutUser } from "../services/authService";
import { Navigate, useNavigate } from "react-router-dom";
import { GetProfile } from "../services/DashboardService";

function Dashboard(){

const navigate = useNavigate();

    const handleLogOut = ()=> {
        logoutUser()
        navigate("/login")
    }

    const[profile, setProfile] = useState("")

    useEffect(()=>{

        try {
            async function LoadProfile() {
            const data = await GetProfile();
            setProfile(data)
            console.log(data)
            
        }
  

        LoadProfile()
        } catch (error) {
            throw error
        }


        
    }, [])

    if(!profile) {
        return <p>Loading....</p>
    }


    return(
        <div className="Dashboard">
            <h1>Welcome, {profile.data.username}</h1>
            <button onClick={handleLogOut}  style={{"width":"100px", "height":"40px"}}>Logout</button>
        </div>
    )

}

export default Dashboard