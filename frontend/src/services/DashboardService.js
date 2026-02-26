import axios from "axios";
import { getToken } from "./authService";

const API_URL = "http://localhost:8080/api/auth/profile"

export async function GetProfile() {

    const token = getToken()
    
    try {
        
        const response = await fetch(`${API_URL}`, {
            method:"GET",
            headers:{
                "Authorization" : `Bearer ${token}`,
                "Content-Type": "application/json"
            }
        });

        if(!response.ok){
            throw new Error("failed to fetch profile")
        }

        const data = await response.json();
        return data

    } catch (error) {
        throw error
    }
}