package com.example.bookservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for manage a book purchase.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPurchaseDto {

    @NotNull
    @Min(value = 0)
    private Integer bookQuantity;
}
