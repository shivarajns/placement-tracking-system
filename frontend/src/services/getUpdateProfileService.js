export function getUpdatedProfile() {
    return{
        username: document.getElementById("username").value,
        phone: document.getElementById("phone").value,
        location: document.getElementById("location").value,
        institute: document.getElementById("institute").value,
        course: document.getElementById("course").value,
        branch: document.getElementById("branch").value,
        domain: document.getElementById("domain").value,
        skills: document.getElementById("skills").value  
    };
}