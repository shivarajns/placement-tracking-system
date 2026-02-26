package com.Uniplace.backend.DTO;


import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentProfileRequest {
    private String username;

    @Pattern(regexp = "^[0-9]{10}$", message = "phone number must be 10 Digits")
    private String phone;

    private String location;

    private String institute;
    private String course;
    private String branch;

    private String domain;

    private String skills;
}
