package com.Uniplace.backend.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recruiter")
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruiter_id")
    private int recruiterId;

    @Column(name = "recruiter_name")
    private String recruiterName;

    private String email;

    private String phone;

    @Column(name = "desigination")
    private String designation;

    @Column(name = "recruiter_bio")
    private String recruiterBio;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "recruiter")
    private List<Job> jobs;

}