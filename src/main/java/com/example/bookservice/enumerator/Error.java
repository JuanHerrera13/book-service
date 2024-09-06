package com.example.bookservice.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {

    NO_BOOKS_FOUND("NO_BOOKS_FOUND", "No books were found."),
    NO_BOOK_FOUND_BY_ID("NO_BOOK_FOUND_BY_ID", "No book was found with the given id."),
    NO_BOOK_FOUND_BY_TITLE("NO_BOOK_FOUND_BY_TITLE", "No book was found with the given title."),
    BOOK_ALREADY_REGISTERED("BOOK_ALREADY_REGISTERED",
            "Book is already registered.");

    private final String errorMessage;
    private final String errorDescription;
}