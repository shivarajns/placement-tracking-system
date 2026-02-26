package com.Uniplace.backend.Controller;

import com.Uniplace.backend.DTO.ApiResponse;
import com.Uniplace.backend.DTO.StudentProfileResponse;
import com.Uniplace.backend.DTO.UpdateStudentProfileRequest;
import com.Uniplace.backend.Service.Implementation.StudentProfileService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @GetMapping("/profile")
    public ApiResponse<StudentProfileResponse> getProfile(Authentication auth){
        String email = auth.getName();

        StudentProfileResponse profileResponse = service.getProfile(email);
        return new ApiResponse<>(true, "profile fetched", profileResponse);
    }

    @PutMapping("/profile")
    public ApiResponse<StudentProfileResponse> updateProfile(
            Authentication auth,
            @Valid @RequestBody UpdateStudentProfileRequest request
            ) {
        String email = auth.getName();

        StudentProfileResponse update = service.updateStudentProfile(email, request);

        return new ApiResponse<>(true, "Profile Updated", update);
    }
}
