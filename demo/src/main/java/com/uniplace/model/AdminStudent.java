package com.uniplace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="admin_students")
public class AdminStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "USN is required")
    @Column(nullable = false)
    private String usn;

    @NotBlank(message = "Institute ID is required")
    @Column(nullable = false, name = "institute_id")
    private String instituteID;

    @NotBlank(message = "Branch name is required")
    @Column(nullable = false)
    private String branch;

    @NotBlank(message = "Institute name is required")
    @Column(nullable = false, name = "institute_name")
    private String instituteName;

    @Column(name = "is_registered")
    private Boolean isRegistered = false;
}
