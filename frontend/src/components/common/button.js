import React from "react";
import "../../style/common/Button.css"

function Button(props){

    return(
        <div className="button-cnt">

            <button id={props.id} className={props.className} onClick={props.onClick}>{props.content}</button>
        </div>
    )
}

export default Button