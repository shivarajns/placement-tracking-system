package com.Uniplace.backend.Controller;

import com.Uniplace.backend.DTO.RegisterResponse;
import com.Uniplace.backend.DTO.UserDto;
import com.Uniplace.backend.Exceptions.UserAlreadyRegisteredException;
import com.Uniplace.backend.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        try{
            UserDto registeredUser = userService.registerUser(userDto);
            RegisterResponse response = new RegisterResponse(
                    "Register Successful",
                    registeredUser.getEmail(),
                    registeredUser.getRole()
            );

            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }
        catch (UserAlreadyRegisteredException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
