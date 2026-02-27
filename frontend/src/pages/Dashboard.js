import React, { useEffect, useState } from "react";
import { logoutUser } from "../services/authService";
import { Navigate, useNavigate } from "react-router-dom";
import { GetProfile } from "../services/DashboardService";
import "../style/pages/Dashboard.css"

function Dashboard() {

    const navigate = useNavigate();

    const handleLogOut = () => {
        logoutUser()
        navigate("/login")
    }

    const [profile, setProfile] = useState("")


    useEffect(() => {

        try {
            async function LoadProfile() {
                const data = await GetProfile();
                setProfile(data)
            }


            LoadProfile()
        } catch (error) {
            throw error
        }



    }, [])

    if (!profile) {
        return <p>Loading....</p>
    }


    return (
        <div className="Dashboard">
            <h2>Welcome, {profile.data.username}</h2>
            <div className="Dashboard-Prfile-cnt">
                <div className="profile-pic">
                    <p className="pic">{profile.data.username ?.substring(0, 2)}</p>
                </div>
                <div style={{ "width": "100%", "paddingLeft": "10px", "textAlign": "center" }}>
                    <p className="userName">{profile.data.username}</p>
                </div>

            </div>
            <div className="details">
                <h2>Personal Details</h2>

                <div className="sub-cnt">
                    <h4>Email</h4>
                    <p>{profile.data.email}</p>
                </div>

                <div className="sub-cnt">
                    <h4>Phone</h4>
                    <p>{profile.data.phone ? profile.data.phone : "Edit to Enter phone number"}</p>
                </div>

                <div className="sub-cnt">
                    <h4>Location</h4>
                <p>{profile.data.location ? profile.data.location : "Edit to Enter Location"}</p>
                </div>

                
            </div>
            <div className="details">
                <h2>Academics Details</h2>

                <div className="sub-cnt">
                    <h4>Instutute Name</h4>
                    <p>{profile.data.institute ? profile.data.institute : "Edit to Enter Institute Name"}</p>
                </div>
                <div className="sub-cnt">
                    <h4>Course</h4>
                    <p>{profile.data.course ? profile.data.course : "Edit to Enter Course"}</p>
                </div>
                <div className="sub-cnt">
                    <h4>Branch</h4>
                    <p>{profile.data.branch ? profile.data.branch : "Edit to Enter Branch"}</p>
                </div>
            </div>


            <div className="details">
                <h2>Skills</h2>
                <div className="sub-cnt">
                    <p>{profile.data.skills ? profile.data.skills : "Edit to Enter Skills"}</p>
                </div>
            </div>

            <div className="details">
                <h2>Intrested Domain</h2>
                <div className="sub-cnt">
                    <p>{profile.data.domain ? profile.data.domain : "Edit to Enter Domain"}</p>
                </div>
            </div>
            <div style={{"display":"flex", "alignItems":"center", "justifyContent": "center"}}>
            <button onClick={handleLogOut} style={{ "width": "100px", "height": "40px"}}>Logout</button>
            </div>
        </div>
    )

}

export default Dashboard