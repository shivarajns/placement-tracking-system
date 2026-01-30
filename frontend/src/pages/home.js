import React from "react";
import "../styles/pages/home.css"
import Footer from "../components/common/footer";




function Home() {
    return (
        <div className="HomePage">
            <div style={{ "backgroundColor": "#0A2540", "padding" : "5px"}}>

                <h1>Simplifying Campus Placements & Internships</h1>
                <p>A centralized platform for students, recruiters, and placement cells to manage opportunities, applications, and outcomes efficiently.</p>

            </div>
            <div className="HomeCard">
                <h2 className="heading">🎓Students</h2>
                <div className="points">
                    <ul>
                        <li>
                            <h4>Discover opportunities</h4>
                        </li>
                        <li>
                            <h4>Manage profile</h4>
                        </li>
                        <li>
                            <h4>Apply & track status</h4>
                        </li>
                    </ul>
                </div>
            </div>

            <div className="HomeCard">
                <h2 className="heading">🏢Recruiters</h2>
                <div className="points">
                    <ul>
                        <li>
                            <h4>Post jobs & internships</h4>
                        </li>
                        <li>
                            <h4>Review applicants</h4>
                        </li>
                        <li>
                            <h4>Shortlist candidates</h4>
                        </li>
                    </ul>
                </div>
            </div>

            <div className="HomeCard">
                <h2 className="heading">🛠️Admin</h2>
                <div className="points">
                    <ul>
                        <li>
                            <h4>Manage users & postings</h4>
                        </li>
                        <li>
                            <h4>Review applicants</h4>
                        </li>
                        <li>
                            <h4>Shortlist candidates</h4>
                        </li>
                    </ul>
                </div>
            </div>

            <div className="Home-Heading">
                Why UniPlace?
            </div>
            <div className="points-cntr">
                <h3>🔐 Secure role-based access</h3>
                <h3>📊 Application tracking & analytics</h3>
                <h3>🧱 Structured recruitment workflow</h3>
                <h3>⚙️ Clean & scalable architecture</h3>
            </div>

            <Footer/>
        </div>
    )
}

export default Home