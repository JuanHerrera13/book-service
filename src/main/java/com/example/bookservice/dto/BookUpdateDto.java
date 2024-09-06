package com.example.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateDto {

    private String title;

    private String author;

    private String genre;

    private float price;

    private int quantity;
}
