import React, { useEffect, useState } from "react";
import "../style/pages/DashboardEdit.css"
import { GetProfile } from "../services/DashboardService";
import { getUpdatedProfile } from "../services/getUpdateProfileService";
import { UpdateProfile } from "../services/UpdateProfileService";


function DashboardEdit() {

    const[profile, setProfile] = useState();

    useEffect(()=>{
        console.log(profile);
    },[profile])

    useEffect( ()=>{
        try {
            async function LoadProfile() {
                const response = await GetProfile();
                setProfile(response.data);
            }
            LoadProfile();
            
        } catch (error) {
            console.error(error);
        }
        
    }, []

    )

    async function handleSubmit() {
        const updatedProfile = getUpdatedProfile();

        try {
            const response = await UpdateProfile(updatedProfile);
            console.log(response);
        } catch (error) {
            throw Error(error)
        }
    }


    return(
        <div className="edit-container">

            <div className="edit-card">
                <h2 className="edit-title">Edit Profile</h2>

                <form className="edit-form" onSubmit={handleSubmit}>

                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <input
                            type="text"
                            id="username"
                            className="username"
                            defaultValue={profile?.username}
                            placeholder="Enter your username"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="phone">Phone Number</label>
                        <input
                            type="text"
                            id="phone"
                            className="phone"
                            defaultValue={profile?.phone}
                            pattern="[0-9]{10}"
                            placeholder="Enter 10 digit phone number"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="location">Location</label>
                        <input
                            type="text"
                            id="location"
                            className="location"
                            defaultValue={profile?.location}
                            placeholder="Enter your location"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="institute">Institute</label>
                        <input
                            type="text"
                            id="institute"
                            className="institute"
                            defaultValue={profile?.institute}
                            placeholder="Enter your institute"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="course">Course</label>
                        <input
                            type="text"
                            id="course"
                            className="course"
                            defaultValue={profile?.course}
                            placeholder="Enter your course"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="branch">Branch</label>
                        <input
                            type="text"
                            id="branch"
                            className="branch"
                            defaultValue={profile?.branch}
                            placeholder="Enter your branch"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="domain">Domain</label>
                        <input
                            type="text"
                            id="domain"
                            className="domain"
                            defaultValue={profile?.domain}
                            placeholder="Enter your domain"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="skills">Skills</label>
                        <input
                            type="text"
                            id="skills"
                            className="skills"
                            defaultValue={profile?.skills}
                            placeholder="Enter skills (comma separated)"
                        />
                    </div>

                    <button type="submit" className="save-btn" style={{"height":"40px"}}>
                        Save Changes
                    </button>

                </form>
            </div>

        </div>
    )
}

export default DashboardEdit;