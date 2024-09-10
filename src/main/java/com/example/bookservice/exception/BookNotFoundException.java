package com.example.bookservice.exception;

/**
 * Exception to be thrown when book is not found.
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
