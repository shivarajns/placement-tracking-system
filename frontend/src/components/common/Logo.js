import React from "react"
import logo from "../../assets/logo/UniPlaceLogo.png"
import "../../styles/logo/logo.css"

function Logo() {

    return (

        <div className="logo">
            <img src={logo} alt="UniPlace" style={{"max-width":"100vw", "height" : "120px"}}></img>
            <h4 style={{"margin":"auto", "marginTop":"-20px", "textAlign":"center"}} className="logo-text">Placement & Internship Platform</h4>
        </div>
    )
}

export default Logo