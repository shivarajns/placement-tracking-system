import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../../style/common/navbar.css";

function Navbar() {
    const [open, setOpen] = useState(false);

    return (
        <nav>
            <div className="nav-left">
                <h1>UniPlace</h1>
            </div>

            <div className={`nav-right ${open ? "open" : ""}`}>
                <Link className="Link" to="/" onClick={() => setOpen(false)}>Home</Link>
                <Link className="Link" to="/login" onClick={() => setOpen(false)}>Profile</Link>
            </div>

            <div className="hamburger" onClick={() => setOpen(!open)}>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </nav>
    );
}

export default Navbar;
