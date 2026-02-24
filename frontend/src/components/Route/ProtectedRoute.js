import { Navigate } from "react-router-dom";
import { getToken } from "../../services/authService";

function ProtectedRouter({children}){
    const token = getToken();

    if(!token) {
        return <Navigate to="/login" />
    }

    return children
}

export default ProtectedRouter