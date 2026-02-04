package com.uniplace.exception;

public class StudentNotEligibleException extends RuntimeException{
    public StudentNotEligibleException(String message){
        super(message);
    }
}
