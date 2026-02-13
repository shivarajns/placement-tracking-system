package com.Uniplace.backend.Controller;

import com.Uniplace.backend.Config.JwtUtil;
import com.Uniplace.backend.DTO.LoginRequest;
import com.Uniplace.backend.DTO.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "http//:localhost/3000")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse logn (@RequestBody LoginRequest request){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken((org.springframework.security.core.userdetails.UserDetails)
        authentication.getPrincipal());

        return new LoginResponse(token);
    }
}
