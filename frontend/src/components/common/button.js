import React from "react";
import "../../style/common/button.css"

function Button(props) {

    return(
        <div className="button">
            <button>{props.cont}</button>
        </div>
    )
}

export default Button