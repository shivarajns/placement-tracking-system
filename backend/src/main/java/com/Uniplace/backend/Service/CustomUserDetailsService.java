package com.Uniplace.backend.Service;

import com.Uniplace.backend.Model.CustomUserDetails;
import com.Uniplace.backend.Model.User;
import com.Uniplace.backend.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with Email"));

        return new CustomUserDetails(user);
    }
}
