package com.calendar.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    @Min(value = 1, message = "ID must be greater than 0")
    private long id;

    @Min(value = 1, message = "Country ID must be greater than 0")
    private long idCountry;

    @Size(max = 100, message = "Holiday name must be less than 100 characters")
    private String name;

    @Min(value = 1, message = "Day must be at least 1")
    @Max(value = 31, message = "Day must be at most 31")
    private int day;

    @Min(value = 1, message = "Month must be at least 1")
    @Max(value = 12, message = "Month must be at most 12")
    private int month;

    private int easterDays;

    @Min(value = 1, message = "Type ID must be greater than 0")
    private int idType;
}