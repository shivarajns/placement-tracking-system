package com.Uniplace.backend.Exceptions;

public class UserNameNotFoundException extends RuntimeException{
    public UserNameNotFoundException(String message){
        super(message);
    }
}
