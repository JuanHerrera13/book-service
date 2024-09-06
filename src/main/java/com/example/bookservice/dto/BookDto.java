package com.example.bookservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDto {

    @NotBlank
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String genre;

    @NotNull
    private float price;

    @NotNull
    private int quantity;
}
