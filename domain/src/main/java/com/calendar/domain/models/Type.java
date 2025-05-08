package com.calendar.domain.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    @Min(value = 1, message = "ID must be greater than 0")
    private Long id;

    @NotNull(message = "Type cannot be null")
    @NotEmpty(message = "Type cannot be empty")
    @Size(max = 50, message = "Type must be less than 50 characters")
    private String type;
    @NotNull(message = "Description cannot be null")
    @NotEmpty(message = "Description cannot be empty")
    @Size(max = 50, message = "Description must be less than 50 characters")
    private String description;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String Name;
}