import React, { useEffect, useState } from "react";
import '../../styles/navbar/navbar.css'
import hamSym from "../../assets/icons/menus.png"
import Sidebar from "./sidebar";

function Navbar () {

    const [click, isClick] = useState(false);

    const HamBtn = () => {
        isClick(prev => !prev);
    }

    useEffect(()=>{
        console.log(click)
    }, [click])



    return(
        <div className="NavBar">
            <img className="HamSym" src={hamSym} alt="Menu" onClick={HamBtn}></img>
            {click && <Sidebar/>}
        </div>
    )
}

export default Navbar