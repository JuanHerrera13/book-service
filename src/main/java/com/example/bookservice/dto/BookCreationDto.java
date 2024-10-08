package com.example.bookservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for creating a new book.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreationDto {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String genre;

    @NotNull
    private Float price;

    @NotNull
    @Min(value = 0)
    private Integer quantity;
}
