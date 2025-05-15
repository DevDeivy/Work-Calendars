package com.calendar.application.services;


import com.calendar.domain.models.Type;
import com.calendar.domain.repositories.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    public Optional<Type> getTypeById(Long id) {
        return typeRepository.findById(id);
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type updateType(Type type) {
        if (typeRepository.existsById(type.getId())) {
            return typeRepository.update(type);
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