import React from "react";
import "../style/pages/DashboardEdit.css"

function DashboardEdit() {

    return(
        <div className="edit-container">

            <div className="edit-card">
                <h2 className="edit-title">Edit Profile</h2>

                <form className="edit-form">

                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <input
                            type="text"
                            id="username"
                            className="username"
                            defaultValue="Shivaraju"
                            placeholder="Enter your username"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="phone">Phone Number</label>
                        <input
                            type="text"
                            id="phone"
                            className="phone"
                            defaultValue="9876543210"
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
                            defaultValue="Bangalore"
                            placeholder="Enter your location"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="institute">Institute</label>
                        <input
                            type="text"
                            id="institute"
                            className="institute"
                            defaultValue="XYZ Engineering College"
                            placeholder="Enter your institute"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="course">Course</label>
                        <input
                            type="text"
                            id="course"
                            className="course"
                            defaultValue="B.E"
                            placeholder="Enter your course"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="branch">Branch</label>
                        <input
                            type="text"
                            id="branch"
                            className="branch"
                            defaultValue="Computer Science"
                            placeholder="Enter your branch"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="domain">Domain</label>
                        <input
                            type="text"
                            id="domain"
                            className="domain"
                            defaultValue="Java Backend Development"
                            placeholder="Enter your domain"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="skills">Skills</label>
                        <input
                            type="text"
                            id="skills"
                            className="skills"
                            defaultValue="Java, Spring Boot, MySQL"
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