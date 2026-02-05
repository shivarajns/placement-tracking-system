package com.uniplace.service.imp;

import com.uniplace.dto.LoginRequest;
import com.uniplace.dto.LoginResponse;
import com.uniplace.exception.InvalidCredentialsException;
import com.uniplace.model.StudentProfile;
import com.uniplace.model.User;
import com.uniplace.repository.StudentProfileRepository;
import com.uniplace.repository.UserRepository;
import com.uniplace.service.LoginService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final PasswordEncoder passwordEncoder;


    public LoginServiceImpl(UserRepository userRepository, StudentProfileRepository studentProfileRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail());

        if(user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid Email or Password");
        }

        return new LoginResponse("Login Successful", user.getRole());
    }
}
