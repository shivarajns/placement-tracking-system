package com.uniplace.service;

import com.uniplace.model.user;
import com.uniplace.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;


    //Code for user to register
    public user registerUser(user user){
            if(userRepository.findByEmail(user.getEmail()).isPresent()){
                throw new RuntimeException("Email already registered");
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            return userRepository.save(user);
    }

    //Code for user to Login
    public user login(String email, String password){
        user user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("invalid credentials");
        }

        return user;
    }
}
