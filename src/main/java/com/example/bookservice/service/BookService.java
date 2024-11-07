package com.example.bookservice.service;

import com.example.bookservice.domain.Book;
import com.example.bookservice.dto.BookCreationDto;
import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book findBookById(String id);

    BookDto findBookByTitle(String title);

    List<BookDto> findAllBooks();

    BookDto addBook(BookCreationDto bookCreationDto);

    BookDto updateBook(String bookId, BookUpdateDto bookUpdateDto);

    void deleteBook(String bookId);

    void bookPurchase(String bookId);
}
