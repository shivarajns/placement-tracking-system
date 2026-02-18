package com.Uniplace.backend.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasRole('Admin')")
    public String adminAccess(){
        return "Welcome Admin";
    }
}
