package com.calendar.api.controllers;

import com.calendar.application.services.HolidayService;
import com.calendar.domain.models.Holiday;
import com.calendar.infrastructure.entities.HolidayEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping
    public ResponseEntity<HolidayEntity> create(@RequestBody HolidayEntity holiday) {
        return ResponseEntity.ok(holidayService.createHoliday(holiday));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayEntity> getById(@PathVariable Long id) {
        return holidayService.getHoliday(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<HolidayEntity>> getAll() {
        return ResponseEntity.ok(holidayService.getAllHolidays());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HolidayEntity> update(@PathVariable Long id, @RequestBody HolidayEntity holiday) {
        holiday.setId(id);
        return ResponseEntity.ok(holidayService.updateHoliday(holiday));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/date")
    public ResponseEntity<LocalDate> getHolidayDate(@PathVariable Long id, @RequestParam int year) {
        return holidayService.getHoliday(id)
                .map(holiday -> ResponseEntity.ok(holidayService.getHolidayDate(holiday, year)))
                .orElse(ResponseEntity.notFound().build());
    }
}