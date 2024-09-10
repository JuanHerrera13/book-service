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

/**
 * Implementation of the BookService interface, providing business logic for managing books.
 */
@Slf4j //  Annotation that generates a logger for the class.
@Service // Indicates that this class is a service component in Spring.
@RequiredArgsConstructor // Annotation that generates a constructor with all final fields.
public class BookServiceImpl implements BookService {

    private static final String SEARCHING_BOOK_BY_TITLE_LOG = "Searching book by title {}";

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    /**
     * Finds and returns all books in the repository.
     * @return A list of BookDto representing all books.
     * @throws BookNotFoundException If no books are found.
     */
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

    /**
     * Finds and returns a book by its ID.
     * @param id The ID of the book.
     * @return The Book object with the specified ID.
     * @throws BookNotFoundException If no book is found with the given ID.
     */
    @Override
    public Book findBookById(String id) {
        log.info("Searching book by id {}", id);
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new BookNotFoundException(NO_BOOK_FOUND_BY_ID.getErrorDescription()));
    }

    /**
     * Finds and returns a book by its title.
     * @param title The title of the book.
     * @return The BookDto representing the book with the specified title.
     * @throws BookNotFoundException If no book is found with the given title.
     */
    @Override
    public BookDto findBookByTitle(String title) {
        log.info(SEARCHING_BOOK_BY_TITLE_LOG, title);
        final Book book = bookRepository.findTopByTitleEqualsIgnoreCase(title)
                .orElseThrow(() -> new BookNotFoundException(NO_BOOK_FOUND_BY_TITLE.getErrorDescription()));
        return bookMapper.bookToBookDto(book);
    }

    /**
     * Adds a new book to the repository.
     * @param bookCreationDto DTO containing the fields of the book to be added.
     * @return The BookDto representing the added book.
     * @throws BookAlreadyRegisteredException If a book with the same title already exists.
     */
    @Override
    public BookDto addBook(BookCreationDto bookCreationDto) {
        log.info(SEARCHING_BOOK_BY_TITLE_LOG, bookCreationDto.getTitle());
        final Optional<Book> bookSearch = bookRepository.findTopByTitleEqualsIgnoreCase(bookCreationDto.getTitle());
        if (bookSearch.isPresent()) {
            log.error(BOOK_ALREADY_REGISTERED.getErrorDescription());
            throw new BookAlreadyRegisteredException(BOOK_ALREADY_REGISTERED.getErrorDescription());
        }
        final Book book = bookMapper.bookCreationDtoToBook(bookCreationDto);
        bookRepository.save(book);
        log.info("Book {} registered with success.", book.getTitle());
        return bookMapper.bookToBookDto(book);
    }

    /**
     * Updates an existing book in the repository.
     * @param bookId The ID of the book to be updated.
     * @param bookUpdateDto DTO containing the updated fields of the book.
     * @return The BookDto representing the updated book.
     */
    @Override
    public BookDto updateBook(String bookId, BookUpdateDto bookUpdateDto) {
        final Book existingBook = this.findBookById(bookId);
        bookMapper.bookUpdateDtoToBook(bookUpdateDto, existingBook);
        bookRepository.save(existingBook);
        log.info("Book {} updated with success.", existingBook.getTitle());
        return bookMapper.bookToBookDto(existingBook);
    }

    /**
     * Deletes a book from the repository.
     * @param bookId The ID of the book to be deleted.
     */
    @Override
    public void deleteBook(String bookId) {
        final Book book = this.findBookById(bookId);
        bookRepository.deleteById(bookId);
        log.info("Book {} deleted.", book.getTitle());
    }
}
