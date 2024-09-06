package com.example.bookservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
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
