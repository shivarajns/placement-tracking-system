import { getToken } from "./authService";

const API_URL = "https://placement-tracking-system.onrender.com/api/auth/profile"

export async function UpdateProfile (updatedProfile) {

    const token = getToken();
    try {

        const response = await fetch(`${API_URL}`, {
            method : "PUT",
            headers:{
                "content-type" : "application/json",
                "Authorization" : `Bearer ${token}`
            },
            body : JSON.stringify(updatedProfile),
        });

        if(!response.ok){
            const error = await response.text();
            throw new Error (error);
        }

        return await response.json();
        
    } catch (error) {
        throw error;
    }
}