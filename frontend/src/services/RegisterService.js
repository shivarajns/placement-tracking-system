import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/register"

export async function RegisterUser(UserData){
    try {

        const response = await fetch(`${API_URL}`, {
            method:"POST",
            headers:{
                "Content-Type":"application/json",
            },
            body: JSON.stringify(UserData),
        })

        if(!response.ok){
            const error = await response.text();
            throw new Error(error)
        }

        return await response.json();
        
    } catch (error) {
        throw error
    }

}