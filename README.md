# placement-tracking-system
UniPlace is a role-based placement and internship tracking platform that manages university placement workflows, company job postings, student applications, and analytics dashboards, built using Spring Boot, MySQL, and React.


# UniPlace – Placement & Internship Platform

UniPlace is a role-based placement and internship tracking platform designed for universities to manage placement workflows, company job postings, student applications, and analytics dashboards. Built using **Spring Boot**, **MySQL**, and **React**, UniPlace demonstrates scalable backend engineering, secure role-based access, and practical workflow management.

---

## Features

### 👥 Role-Based Access Control
- **Student:** Apply to internships and placement drives, track application status.
- **Admin / Placement Cell:** Manage companies, job postings, and application workflows.
- Secure authentication using **JWT** and **Spring Security**.

### 📄 Application Workflow Management
- Applications move through defined stages:  
  `Applied → Technical → HR → Offer → Accepted / Rejected`
- Workflow validation and history tracking to prevent invalid transitions.

### 🏢 Company & Job Management
- Maintain company profiles and job postings.
- Set eligibility criteria: CGPA, branch, batch, etc.
- Auto-filter eligible students.

### 📊 Analytics Dashboard
- Stage-wise conversion rates.
- Applications per company.
- Average processing time per stage.
- Trends to identify placement performance gaps.

### ⚙️ Backend Engineering Depth
- Optimized **REST APIs** with pagination, filtering, and DTOs.
- Transactional consistency and soft deletes.
- Exception handling and input validation.
- Database design with normalization, indexing, and relationships.

---

## Tech Stack

- **Backend:** Spring Boot, Spring Security, JPA/Hibernate, MySQL
- **Frontend:** React
- **Authentication:** JWT
- **Other:** Maven, Node.js/NPM (for frontend), optional Redis for caching

---

## Project Structure

frontend/
├── public/                     
├── src/
│   ├── components/             
│   ├── pages/                  
│   ├── services/               
│   ├── utils/                  
│   ├── App.js                  
│   └── index.js                
├── package.json
└── README.md


