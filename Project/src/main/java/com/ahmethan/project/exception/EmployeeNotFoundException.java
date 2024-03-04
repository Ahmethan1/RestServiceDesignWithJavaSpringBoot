package com.ahmethan.project.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
