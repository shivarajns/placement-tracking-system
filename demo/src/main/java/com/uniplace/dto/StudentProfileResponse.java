package com.uniplace.dto;

import lombok.Data;

@Data
public class StudentProfileResponse {

    private String name;
    private String usn;
    private String branch;
    private String instituteName;
    private String instituteId;
    private String role;
    private Boolean isComplete;
}
