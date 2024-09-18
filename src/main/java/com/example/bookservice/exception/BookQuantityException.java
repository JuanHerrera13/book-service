package com.example.bookservice.exception;

public class BookQuantityException extends RuntimeException {

    public BookQuantityException(String message) {
        super(message);
    }
}
