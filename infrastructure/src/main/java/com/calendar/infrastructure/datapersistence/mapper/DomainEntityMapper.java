package com.calendar.infrastructure.datapersistence.mapper;

import com.calendar.domain.models.Country;
import com.calendar.domain.models.Holiday;
import com.calendar.domain.models.Type;
import com.calendar.infrastructure.entities.CountryEntity;
import com.calendar.infrastructure.entities.HolidayEntity;
import com.calendar.infrastructure.entities.TypeEntity;

import java.time.LocalDate;

public class DomainEntityMapper {

    // Country
    public static CountryEntity toEntity(Country country) {
        return new CountryEntity(country.getId(), country.getName());
    }

    public static Country toDomain(CountryEntity entity) {
        Country country = new Country();
        country.setId(entity.getId());
        country.setCode(""); // Si no tienes un campo "code" en entity
        country.setName(entity.getName());
        return country;
    }

    // Holiday
    public static HolidayEntity toEntity(Holiday holiday) {
        return new HolidayEntity(
                holiday.getId(),
                holiday.getIdCountry(),
                holiday.getName(),
                holiday.getDay(),
                holiday.getMonth(),
                holiday.getEasterDays(),
                holiday.getIdType()
        );
    }

    public static Holiday toDomain(HolidayEntity entity) {
        Holiday holiday = new Holiday();
        holiday.setId(entity.getId());
        holiday.setIdCountry(entity.getIdCountry());
        holiday.setName(entity.getName());
        holiday.setDay(entity.getDay());
        holiday.setMonth(entity.getMonth());
        holiday.setEasterDays(entity.getEasterDays());
        holiday.setIdType(entity.getIdType());
        // Estimación de fecha por día y mes
        holiday.setDate(LocalDate.of(2025, entity.getMonth(), entity.getDay())); // Ajusta el año si es necesario
        return holiday;
    }

    // Type
    public static TypeEntity toEntity(Type type) {
        return new TypeEntity(type.getId(), type.getType());
    }

    public static Type toDomain(TypeEntity entity) {
        Type type = new Type();
        type.setId(entity.getId());
        type.setName(entity.getType());
        type.setDescription(""); // Por defecto vacío
        return type;
    }
}
