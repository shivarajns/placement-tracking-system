package com.uniplace.controller;

import com.uniplace.dto.LoginRequest;
import com.uniplace.dto.LoginResponse;
import com.uniplace.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final LoginService loginService;

    public LoginController (LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        LoginResponse loginResponse = loginService.login(request);

        return ResponseEntity.ok(loginResponse);
    }
}
