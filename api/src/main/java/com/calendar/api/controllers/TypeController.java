package com.calendar.api.controllers;

import com.calendar.application.services.TypeService;
import com.calendar.domain.models.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity<Type> create(@RequestBody Type type) {
        return ResponseEntity.ok(typeService.createType(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getById(@PathVariable Long id) {
        return typeService.getTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Type>> getAll() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> update(@PathVariable Long id, @RequestBody Type type) {
        type.setId(id);
        return ResponseEntity.ok(typeService.updateType(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        typeService.deleteType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByName(@RequestParam String name) {
        return ResponseEntity.ok(typeService.existsByName(name));
    }
}