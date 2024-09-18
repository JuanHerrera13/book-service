package com.example.bookservice.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing different error types and their messages.
 */
@Getter
@AllArgsConstructor
public enum Error {

    NO_BOOKS_FOUND("NO_BOOKS_FOUND", "No books were found."),
    NO_BOOK_FOUND_BY_ID("NO_BOOK_FOUND_BY_ID", "No book was found with the given id."),
    NO_BOOK_FOUND_BY_TITLE("NO_BOOK_FOUND_BY_TITLE", "No book was found with the given title."),
    BOOK_ALREADY_REGISTERED("BOOK_ALREADY_REGISTERED",
            "Book is already registered."),
    INVALID_BOOK_QUANTITY_MESSAGE("INVALID_BOOK_QUANTITY_MESSAGE",
            "The book quantity must be greater than 0 and less than or equal to the available stock.");

    private final String errorMessage;
    private final String errorDescription;
}
