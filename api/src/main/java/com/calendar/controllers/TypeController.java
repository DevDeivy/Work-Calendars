package com.calendar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.calendar.application.services.TypeService;
import com.calendar.dtos.TypeDTO;
import com.calendar.domain.models.Type;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        List<TypeDTO> types = typeService.getAllTypes().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Long id) {
        return typeService.getTypeById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TypeDTO> createType(@RequestBody TypeDTO typeDTO) {
        Type createdType = typeService.createType(toEntity(typeDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(createdType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDTO> updateType(@PathVariable Long id, @RequestBody TypeDTO typeDTO) {
        Type typeToUpdate = toEntity(typeDTO);
        typeToUpdate.setId(id);
        try {
            Type updatedType = typeService.updateType(typeToUpdate);
            return ResponseEntity.ok(toDTO(updatedType));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        try {
            typeService.deleteType(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private TypeDTO toDTO(Type type) {
        TypeDTO dto = new TypeDTO();
        dto.setId(type.getId());
        dto.setName(type.getName());
        dto.setDescription(type.getDescription());
        return dto;
    }

    private Type toEntity(TypeDTO dto) {
        Type type = new Type();
        type.setId(dto.getId());
        type.setName(dto.getName());
        type.setDescription(dto.getDescription());
        return type;
    }
}
