package com.example.bookservice.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for updating a new book.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateDto {

    private String title;

    private String author;

    private String genre;

    @Digits(integer = 10, fraction = 2)
    private Float price;

    @Min(value = 0)
    private Integer quantity;
}
