package com.Uniplace.backend.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    @Email(message = "Enter Valid Email")
    private String email;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    @Size(min = 5, max = 20)
    private String password;

}
