import React from "react";
import "../../style/common/navbar.css"
import Button from "./button";

function Navbar() {
    return(
        <div className="navbar">
            <div className="nav-left">
                <p>UniPlace</p>
            </div>

            <div className="nav-right">
                <Button cont="Login/Signup" />
            </div>
        </div>
    )
}

export default Navbar