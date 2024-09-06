package com.example.bookservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer quantity;
}
