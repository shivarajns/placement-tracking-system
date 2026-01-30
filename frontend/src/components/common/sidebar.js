import React from "react";
import "../../styles/navbar/navbar.css"
function Sidebar() {
    return(
        <div className="sideBar">
            <div className="navIteams">
                <ul className="ul">
                    <a href="https://google.com"><li>Home</li></a>
                    <li>Profile</li>
                    <li>Contact</li>
                    
                </ul>
            </div>
        </div>
    )
}

export default Sidebar