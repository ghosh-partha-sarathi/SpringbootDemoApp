package com.example.demo.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerAlreadyExistsException extends Exception {
    private String message = "Customer already exists";
    public CustomerAlreadyExistsException(String msg) {
        this.message=msg;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
