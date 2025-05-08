package com.calendar.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Min(value = 1, message = "ID must be greater than 0")
    private Long id;

    @NotNull(message = "Country name cannot be null")
    @NotEmpty(message = "Country name cannot be empty")
    @Size(max = 100, message = "Country name must be less than 100 characters")
    private String name;

    @NotNull(message = "Country code cannot be null")
    @NotEmpty(message = "Country code cannot be empty")
    @Size(max = 10, message = "Country code must be less than 10 characters")
    private String code;
}
