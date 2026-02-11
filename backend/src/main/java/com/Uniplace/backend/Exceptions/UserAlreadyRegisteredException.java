package com.Uniplace.backend.Exceptions;

public class UserAlreadyRegisteredException extends RuntimeException{
        public UserAlreadyRegisteredException(String message){
            super(message);
        }
}
