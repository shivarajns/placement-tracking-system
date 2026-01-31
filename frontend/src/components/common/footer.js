import React from "react";
import "../../style/common/footer.css"

function Footer() {

    return (
        <div className="footer">
            <div className="contact">
                <h2>Contact</h2>
                
                <div className="contact-cnt-a">
                <p>Email: shivarajns.work@gmail.com</p>
                <a
                    href="https://www.linkedin.com/in/shivaraju-ns-0642a6291/"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    linkedin
                </a>
                <a href="https://github.com/shivarajns" 
                    target="_blank"
                    rel="noopener noreferrer">
                    GitHub
                </a>
                </div>

                <div className="contact-cnt-b">
                    <p>© 2026 UniPlace | All rights reserved</p>
                </div>
            </div>
        </div>
    )
}

export default Footer