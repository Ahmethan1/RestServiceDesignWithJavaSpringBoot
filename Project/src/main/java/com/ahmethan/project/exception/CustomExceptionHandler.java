package com.ahmethan.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> employeeNotFound(EmployeeNotFoundException exception){
        List<String> detail=new ArrayList<>();
        detail.add(exception.getMessage());
        ErrorResponse response=new ErrorResponse("Employee Not Found",detail);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeNotNullException.class)
    public ResponseEntity<?> employeeNotNull(EmployeeNotNullException nullException){
        List<String> detail=new ArrayList<>();
        detail.add(nullException.getMessage());
        ErrorResponse response =new ErrorResponse("Employee Not Null",detail);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvoiceNotNullException.class)
    public ResponseEntity<?> invoiceNotNull(InvoiceNotNullException notNullException){
        List<String> detail=new ArrayList<>();
        detail.add(notNullException.getMessage());
        ErrorResponse response=new ErrorResponse("Invoice Not Null",detail);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvoiceLimitException.class)
    public ResponseEntity<?> invoiceLimitException(InvoiceLimitException limitException){
        List<String> detail=new ArrayList<>();
        detail.add(limitException.getMessage());
        ErrorResponse response =new ErrorResponse("Limit Geçildi",detail);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> detail = new ArrayList<>();
        detail.add(exception.getMessage());
        ErrorResponse response = new ErrorResponse("Boş yerler Var",detail);
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}

