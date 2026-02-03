package com.uniplace.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_profiles")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "USN is required")
    @Column(nullable = false)
    private String usn;

    @NotBlank(message = "Institute ID is required")
    @Column(name = "institute_id", nullable = false)
    private String instituteId;

    @NotBlank(message = "Institute Name is required")
    @Column(name = "institute_name", nullable = false)
    private String instituteName;

    @NotBlank(message = "Branch is required")
    @Column(nullable = false)
    private String branch;

    @Column(name = "profile_completed", nullable = false)
    private Boolean profileCompleted = false;
}
