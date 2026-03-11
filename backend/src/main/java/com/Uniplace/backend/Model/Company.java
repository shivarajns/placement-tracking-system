package com.Uniplace.backend.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    private String company_name;
    private String company_website;
    private String company_industry;
    private String company_location;
    private String company_bio;

//    @OneToMany(mappedBy = "company")
//    private List<Recruiter> recruiters;
//
//    @OneToMany(mappedBy = "company")
//    private List<Job> jobs;
}
