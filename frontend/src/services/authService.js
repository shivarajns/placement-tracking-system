import axios from "axios";

const API_URL = "http://localhost:8080/api/auth"

export const LoginUser = async (email, password) => {
    const response = await axios.post(`${API_URL}/login`, {
        email,
        password
    });

    const data = response.data;

    localStorage.setItem("token", data.token)
    localStorage.setItem("email", data.email)
    localStorage.setItem("role", data.role)

    return data;

};

export const logoutUser =()=>{
    localStorage.removeItem("token")
    localStorage.removeItem("email")
    localStorage.removeItem("role")
}

export const getToken = () => {
    return localStorage.getItem("token")
}

export const getUserEmail = ()=> {
    return localStorage.getItem("email")
}

export const getUserRole = ()=> {
    return localStorage.getItem("role")
}


function parsejwt(token){
    try {
        return JSON.parse(atob(token.split(".")[1]))
    } catch (error) {
        return null
    }
}

export function isTokenExpired(token){
    if (!token) return true;

    const decoded = parsejwt(token)
    if(!decoded?.exp) return true

    const currentTime = Date.now() / 1000
    return decoded.exp < currentTime
}

export function isAuthenticated() {
    const token = getToken();

    if(!token || isTokenExpired(token)){
        logoutUser();
        return false
    }

    return true
}

export function saveToken(token) {
    localStorage.setItem("token", token)
}