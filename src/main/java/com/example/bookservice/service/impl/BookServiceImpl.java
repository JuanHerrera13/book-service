package com.example.bookservice.service.impl;

import com.example.bookservice.domain.Book;
import com.example.bookservice.dto.BookCreationDto;
import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookUpdateDto;
import com.example.bookservice.dto.mapping.BookMapper;
import com.example.bookservice.exception.BookAlreadyRegisteredException;
import com.example.bookservice.exception.BookNotFoundException;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.bookservice.enumerator.Error.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private static final String SEARCHING_BOOK_BY_TITLE_LOG = "Searching book by title {}";

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public List<BookDto> findAllBooks() {
        log.info("Searching for books.");
        final List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            log.info(NO_BOOKS_FOUND.getErrorDescription());
            throw new BookNotFoundException(NO_BOOKS_FOUND.getErrorDescription());
        }
        return bookMapper.bookListToBookListDto(books);
    }

    @Override
    public Book findBookById(String id) {
        log.info("Searching book by id {}", id);
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new BookNotFoundException(NO_BOOK_FOUND_BY_ID.getErrorDescription()));
    }

    @Override
    public BookDto findBookByTitle(String title) {
        log.info(SEARCHING_BOOK_BY_TITLE_LOG, title);
        final Book book = bookRepository.findTopByTitle(title)
                .orElseThrow(() -> new BookNotFoundException(NO_BOOK_FOUND_BY_TITLE.getErrorDescription()));
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public BookDto addBook(BookCreationDto bookCreationDto) {
        log.info(SEARCHING_BOOK_BY_TITLE_LOG, bookCreationDto.getTitle());
        final Optional<Book> bookSearch = bookRepository.findTopByTitle(bookCreationDto.getTitle());
        if (bookSearch.isPresent()) {
            log.error(BOOK_ALREADY_REGISTERED.getErrorDescription());
            throw new BookAlreadyRegisteredException(BOOK_ALREADY_REGISTERED.getErrorDescription());
        }
        final Book book = bookMapper.bookCreationDtoToBook(bookCreationDto);
        bookRepository.save(book);
        log.info("Book {} registered with success.", book.getTitle());
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public BookDto updateBook(String bookId, BookUpdateDto bookUpdateDto) {
        final Book existingBook = this.findBookById(bookId);
        bookMapper.bookUpdateDtoToBook(bookUpdateDto, existingBook);
        bookRepository.save(existingBook);
        log.info("Book {} updated with success.", existingBook.getTitle());
        return bookMapper.bookToBookDto(existingBook);
    }

    @Override
    public void deleteBook(String bookId) {
        final Book book = this.findBookById(bookId);
        bookRepository.deleteById(bookId);
        log.info("Book {} deleted.", book.getTitle());
    }
}
