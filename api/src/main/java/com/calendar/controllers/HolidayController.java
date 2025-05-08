package com.calendar.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.calendar.application.services.HolidayService;
import com.calendar.dtos.HolidayDTO;
import com.calendar.domain.models.Holiday;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint(@RequestParam(required = false) String param) {
        return ResponseEntity.ok("OK");
    }

    @GetMapping
    public ResponseEntity<List<HolidayDTO>> getAllHolidays() {
        List<HolidayDTO> holidays = holidayService.getAllHolidays().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(holidays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayDTO> getHolidayById(@PathVariable Long id) {
        return holidayService.getHoliday(id)
            .map(this::toDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HolidayDTO> createHoliday(@RequestBody HolidayDTO holidayDTO) {
        Holiday created = holidayService.createHoliday(toEntity(holidayDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HolidayDTO> updateHoliday(@PathVariable Long id, @RequestBody HolidayDTO holidayDTO) {
        Holiday holiday = toEntity(holidayDTO);
        holiday.setId(id);
        try {
            Holiday updated = holidayService.updateHoliday(holiday);
            return ResponseEntity.ok(toDTO(updated));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable Long id) {
        try {
            holidayService.deleteHoliday(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    private HolidayDTO toDTO(Holiday holiday) {
        HolidayDTO dto = new HolidayDTO();
        dto.setId(holiday.getId());
        dto.setName(holiday.getName());
        dto.setDate(holiday.getDate());
        dto.setCountryId(holiday.getIdCountry());
        return dto;
    }

    private Holiday toEntity(HolidayDTO dto) {
        Holiday holiday = new Holiday();
        holiday.setId(dto.getId());
        holiday.setName(dto.getName());
        holiday.setDate(dto.getDate());
        holiday.setIdCountry(dto.getCountryId());
        return holiday;
    }
}
