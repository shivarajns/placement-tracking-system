package com.uniplace.controller;

import com.uniplace.dto.StudentProfileResponse;
import com.uniplace.service.imp.StudentProfileServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentProfileController {

    private final StudentProfileServiceImp studentProfileServiceImp;

    public StudentProfileController(StudentProfileServiceImp studentProfileServiceImp) {
        this.studentProfileServiceImp = studentProfileServiceImp;
    }

    @GetMapping("/profile")
    public ResponseEntity<StudentProfileResponse> getStudentProfile (@RequestParam String usn){
        StudentProfileResponse profile = studentProfileServiceImp.getStudentProfileByUsn(usn);
        return ResponseEntity.ok(profile);
    }


}
