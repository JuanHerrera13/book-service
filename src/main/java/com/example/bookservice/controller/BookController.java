package com.example.bookservice.controller;

import com.example.bookservice.dto.BookCreationDto;
import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookUpdateDto;
import com.example.bookservice.service.impl.BookServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class where Book data will be created,
 * read, updated and deleted (CRUD) through Book-Service APIs.
 */
@RestController
@RequiredArgsConstructor
public class BookController extends RootController {

    private final BookServiceImpl bookServiceImpl;

    @GetMapping(path = "/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> fetchAllBooks() {
        return bookServiceImpl.findAllBooks();
    }

    @GetMapping(path = "/books/{title}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto fetchBookByTitle(@Valid @PathVariable String title) {
        return bookServiceImpl.findBookByTitle(title);
    }

    @PostMapping(path = "/books/book.add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto addBook(@Valid @RequestBody BookCreationDto bookCreationDto) {
        return bookServiceImpl.addBook(bookCreationDto);
    }

    @PostMapping(path = "/books/{bookId}/book.update")
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable String bookId, @Valid @RequestBody BookUpdateDto bookUpdateDto) {
        return bookServiceImpl.updateBook(bookId, bookUpdateDto);
    }

    @DeleteMapping(path = "/books/{bookId}/book.delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable String bookId) {
        bookServiceImpl.deleteBook(bookId);
    }
}
