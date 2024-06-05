package com.victorcode.restaurantprojectapirestfulspringboot.exceptions;

public class EmailFoundException extends RuntimeException{

    public EmailFoundException() {
        super("The email already exists!");
    }
}
