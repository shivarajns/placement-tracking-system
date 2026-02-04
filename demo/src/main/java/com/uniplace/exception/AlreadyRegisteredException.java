package com.uniplace.exception;

public class AlreadyRegisteredException extends RuntimeException {
    public AlreadyRegisteredException(String message){
        super(message);
    }
}
