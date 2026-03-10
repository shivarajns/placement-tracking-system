

const API_URL = "https://placement-tracking-system.onrender.com/api/auth/register"

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