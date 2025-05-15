package com.calendar.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "holiday")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayEntity {

    @Id
    private Long id;

    @Column(name = "country_id")
    private long idCountry;

    private String name;
    private int day;
    private int month;
    private int easterDays;

    @Column(name = "type_id")
    private int idType;
}
