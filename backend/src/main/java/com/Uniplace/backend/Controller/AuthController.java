package com.Uniplace.backend.Controller;

import com.Uniplace.backend.Config.JwtUtil;
import com.Uniplace.backend.DTO.LoginRequest;
import com.Uniplace.backend.DTO.LoginResponse;
import com.Uniplace.backend.Model.User;
import com.Uniplace.backend.Repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepo userRepo) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
    }

    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest request){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken((org.springframework.security.core.userdetails.UserDetails)
        authentication.getPrincipal());

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User not Found With Email"));

        LoginResponse response = new LoginResponse(
                token,
                "Login Successful",
                user.getEmail(),
                user.getRole().name()


        );

        return ResponseEntity.ok(response).getBody();
    }
}
