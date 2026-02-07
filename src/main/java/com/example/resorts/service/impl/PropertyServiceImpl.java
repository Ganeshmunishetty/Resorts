package com.example.resorts.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.resorts.dto.PropertyRequestDto;
import com.example.resorts.dto.PropertyResponseDto;
import com.example.resorts.entity.Property;
import com.example.resorts.entity.enums.PropertyStatus;
import com.example.resorts.exception.ResourceNotFoundException;
import com.example.resorts.repository.PropertyRepository;
import com.example.resorts.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // ===== ADMIN FLOW (Entity based) =====
    @Override
    public Property createProperty(Property property) {
        property.setStatus(PropertyStatus.ACTIVE);
        property.setCreatedAt(LocalDateTime.now());
        return propertyRepository.save(property);
    }

    // ===== PUBLIC FLOW (DTO based) =====
    @Override
    public PropertyResponseDto createProperty(PropertyRequestDto dto) {

        Property property = new Property();
        property.setName(dto.getName());
        property.setLocation(dto.getLocation());
        property.setDescription(dto.getDescription());
        property.setStatus(PropertyStatus.ACTIVE);
        property.setCreatedAt(LocalDateTime.now());

        Property saved = propertyRepository.save(property);
        return mapToResponse(saved);
    }

    @Override
    public List<PropertyResponseDto> getAllActiveProperties() {
        return propertyRepository.findByStatus(PropertyStatus.ACTIVE)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> getActiveProperty() {
        return propertyRepository.findByStatus(PropertyStatus.ACTIVE);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
    }

    // ===== MAPPER =====
    private PropertyResponseDto mapToResponse(Property property) {
        PropertyResponseDto res = new PropertyResponseDto();
        res.setId(property.getId());
        res.setName(property.getName());
        res.setLocation(property.getLocation());
        res.setStatus(property.getStatus());
        return res;
    }
}
