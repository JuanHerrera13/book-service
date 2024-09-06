package com.example.bookservice.exception;

public class BookAlreadyRegisteredException extends RuntimeException {

    public BookAlreadyRegisteredException(String message) {
        super(message);
    }

}
