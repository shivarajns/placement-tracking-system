package com.Uniplace.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileResponse {

    private String username;
    private String email;
    private String phone;
    private String location;

    private String institute;
    private String course;
    private String branch;

    private String domain;
    private String skills;
}
