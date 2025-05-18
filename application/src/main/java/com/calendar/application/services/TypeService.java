package com.calendar.application.services;


import com.calendar.infrastructure.repositories.TypeRepository;
import com.calendar.infrastructure.entities.TypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public TypeEntity createType(TypeEntity type) {
        return typeRepository.save(type);
    }

    public Optional<TypeEntity> getTypeById(Long id) {
        return typeRepository.findById(id);
    }

    public List<TypeEntity> getAllTypes() {
        return typeRepository.findAll();
    }

    public TypeEntity updateType(TypeEntity type) {
        if (typeRepository.existsById(type.getId())) {
            return typeRepository.save(type);
        } else {
            throw new IllegalArgumentException("Type not found");
        }
    }

    public void deleteType(Long id) {
        if (typeRepository.existsById(id)) {
            typeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Type not found");
        }
    }

    public boolean existsByName(String name) {
        return typeRepository.existsByName(name);
    }
}