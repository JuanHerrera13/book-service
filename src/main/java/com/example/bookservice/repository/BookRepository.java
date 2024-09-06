package com.example.bookservice.repository;

import com.example.bookservice.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface to manage Book data
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    /**
     * Method that fetches the first book found by its title
     * @param title book's title
     * @return Book
     */
    Optional<Book> findTopByTitle(String title);

    /**
     * Method that fetches the book found by its id
     * @param id book's id
     * @return Book
     */
    Optional<Book> findBookById(String id);
}
