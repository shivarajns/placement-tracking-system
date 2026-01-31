import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../../style/Navbar/Navbar.css";

function Navbar() {
  const [isOpen, setIsOpen] = useState(false);
  const [isMobile, setIsMobile] = useState(window.innerWidth <= 768);

  // Update isMobile on window resize
  useEffect(() => {
    const handleResize = () => {
      setIsMobile(window.innerWidth <= 768);
      if (window.innerWidth > 768) setIsOpen(false);
    };
    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  return (
    <nav className="navbar">
      <div className="nav-container">
        <Link to="/" className="nav-logo">
          UniPlace
        </Link>

        {/* Menu Links */}
        <div className={`nav-menu ${isMobile && isOpen ? "active" : ""} ${!isMobile ? "desktop" : ""}`}>
          <Link to="/" className="nav-item" onClick={() => setIsOpen(false)}>
            Home
          </Link>
          <Link to="/login" className="nav-item" onClick={() => setIsOpen(false)}>
            Login/Signup
          </Link>
          <Link to="/about" className="nav-item" onClick={() => setIsOpen(false)}>
            About
          </Link>
          <Link to="/contact" className="nav-item" onClick={() => setIsOpen(false)}>
            Contact
          </Link>
        </div>

        {/* Hamburger */}
        {isMobile && (
          <div className={`nav-icon ${isOpen ? "change" : ""}`} onClick={() => setIsOpen(!isOpen)}>
            <span className="bar"></span>
            <span className="bar"></span>
            <span className="bar"></span>
          </div>
        )}
      </div>
    </nav>
  );
}

export default Navbar;
