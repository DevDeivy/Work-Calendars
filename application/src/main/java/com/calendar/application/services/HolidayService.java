package com.calendar.application.services;

import com.calendar.application.usecases.HolidayDateCalculator;
import com.calendar.infrastructure.repositories.HolidayRepository;
import com.calendar.infrastructure.entities.HolidayEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final HolidayDateCalculator holidayDateCalculator;

    public HolidayService(HolidayRepository holidayRepository, HolidayDateCalculator holidayDateCalculator) {
        this.holidayRepository = holidayRepository;
        this.holidayDateCalculator = holidayDateCalculator;
    }

    public HolidayEntity createHoliday(HolidayEntity holiday) {
        if (holidayRepository.existsByName(holiday.getName())) {
            throw new IllegalArgumentException("Holiday with this name already exists");
        }
        return holidayRepository.save(holiday);
    }

    public Optional<HolidayEntity> getHoliday(Long id) {
        return holidayRepository.findById(id);
    }

    public List<HolidayEntity> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public HolidayEntity updateHoliday(HolidayEntity holiday) {
        if (!holidayRepository.findById(holiday.getId()).isPresent()) {
            throw new IllegalArgumentException("Holiday not found");
        }
        return holidayRepository.save(holiday);
    }

    public void deleteHoliday(Long id) {
        holidayRepository.deleteById(id);
    }

    public LocalDate getHolidayDate(HolidayEntity holiday, int year) {
        return holidayDateCalculator.calculateDate(holiday, year);
    }
}