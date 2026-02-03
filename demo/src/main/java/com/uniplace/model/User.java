package com.uniplace.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"email"}),
            @UniqueConstraint(columnNames = {"usn", "institute_id"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Email is Required")
    @Email(message = "Email should be Valid")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "USN/Student ID is required")
    @Column(nullable = false)
    private String usn;

    @NotBlank(message = "Institute ID is required")
    @Column(name = "institute_id", nullable = false)
    private String institute_id;

    @NotBlank(message = "password is required")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "STUDENT";

}
