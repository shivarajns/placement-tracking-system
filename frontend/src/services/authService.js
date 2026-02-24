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

export const isAuthenticated = () =>{
    return !!localStorage("token")
}