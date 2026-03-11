package com.Uniplace.backend.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_website")
    private String companyWebsite;

    @Column(name = "company_industry")
    private String companyIndustry;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "company_bio")
    private String companyBio;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "company")
    private List<Recruiter> recruiters;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

}