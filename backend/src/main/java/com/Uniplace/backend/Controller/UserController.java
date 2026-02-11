package com.Uniplace.backend.Controller;

import com.Uniplace.backend.DTO.UserDto;
import com.Uniplace.backend.Exceptions.UserAlreadyRegisteredException;
import com.Uniplace.backend.Service.Implementation.UserSerImp;
import com.Uniplace.backend.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){
        try{
            UserDto registeredUser = userService.registerUser(userDto);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        }
        catch (UserAlreadyRegisteredException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
