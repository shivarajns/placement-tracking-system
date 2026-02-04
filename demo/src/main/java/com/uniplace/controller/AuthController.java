package com.uniplace.controller;


import com.uniplace.dto.RegisterRequest;
import com.uniplace.service.RegistrationService;
import com.uniplace.service.imp.RegistrationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private RegistrationService registrationService;

    public AuthController (RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent (
            @Valid @RequestBody RegisterRequest request
            ){
        registrationService.registerStudent(request);

        return ResponseEntity.ok("Register Successful");
    }
}
