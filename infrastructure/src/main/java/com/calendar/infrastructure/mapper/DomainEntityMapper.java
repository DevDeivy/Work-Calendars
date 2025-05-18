package com.calendar.infrastructure.mapper;


import com.calendar.domain.models.Country;
import com.calendar.domain.models.Holiday;
import com.calendar.domain.models.Type;
import com.calendar.infrastructure.entities.CountryEntity;
import com.calendar.infrastructure.entities.HolidayEntity;
import com.calendar.infrastructure.entities.TypeEntity;

public class DomainEntityMapper {

    // Country
    public static CountryEntity toEntity(Country country) {
        return new CountryEntity(country.getId(), country.getName());
    }

    public static Country toDomain(CountryEntity entity) {
        return new Country(entity.getId(), entity.getName());
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
        return new Holiday(
                entity.getId(),
                entity.getIdCountry(),
                entity.getName(),
                entity.getDay(),
                entity.getMonth(),
                entity.getEasterDays(),
                entity.getIdType()
        );
    }

    // Type
    public static TypeEntity toEntity(Type type) {
        return new TypeEntity(type.getId(), type.getType());
    }

    public static Type toDomain(TypeEntity entity) {
        return new Type(entity.getId(), entity.getType());
    }
}

