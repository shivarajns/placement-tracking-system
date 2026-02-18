package com.Uniplace.backend.Service.Implementation;


import com.Uniplace.backend.DTO.UserDto;
import com.Uniplace.backend.Entity.Role;
import com.Uniplace.backend.Exceptions.UserAlreadyRegisteredException;
import com.Uniplace.backend.Model.User;
import com.Uniplace.backend.Repository.UserRepo;
import com.Uniplace.backend.Service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSerImp implements UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder PasswordEncoder;

    public UserSerImp (UserRepo userRepo, BCryptPasswordEncoder PasswordEncoder){
        this.userRepo = userRepo;
        this.PasswordEncoder = PasswordEncoder;
    }

    @Override
    public UserDto registerUser(UserDto userDto){

        if(userRepo.findByEmail(userDto.getEmail()).isPresent()){
            throw new UserAlreadyRegisteredException("User with this mail already Registered");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(PasswordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.valueOf(userDto.getRole().toUpperCase()));

        User saveUSer = userRepo.save(user);

        return new UserDto(saveUSer.getName(), saveUSer.getEmail(), saveUSer.getPassword(), saveUSer.getRole().name());
    }
}
