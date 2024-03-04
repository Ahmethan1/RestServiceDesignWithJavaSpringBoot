package com.ahmethan.project.exception;

public class InvoiceLimitException extends RuntimeException{
    public InvoiceLimitException(String message){
        super(message);
    }
}

