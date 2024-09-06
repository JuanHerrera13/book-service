package com.example.bookservice.dto.mapping;

import com.example.bookservice.domain.Book;
import com.example.bookservice.dto.BookCreationDto;
import com.example.bookservice.dto.BookDto;
import com.example.bookservice.dto.BookUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BookMapper {

    Book bookCreationDtoToBook(BookCreationDto bookCreationDto);

    BookDto bookToBookDto(Book book);

    List<BookDto> bookListToBookListDto(List<Book> books);

    void bookUpdateDtoToBook(BookUpdateDto bookUpdateDto, @MappingTarget Book book);
}
