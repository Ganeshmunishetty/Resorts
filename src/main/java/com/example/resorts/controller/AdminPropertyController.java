package com.example.resorts.controller;

import com.example.resorts.dto.PropertyRequestDto;
import com.example.resorts.dto.PropertyResponseDto;
import com.example.resorts.service.PropertyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/properties")
public class AdminPropertyController {

    private final PropertyService propertyService;

    public AdminPropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // ADMIN: Create new property
    @PostMapping
    public ResponseEntity<PropertyResponseDto> createProperty(
            @RequestBody PropertyRequestDto dto) {

        return new ResponseEntity<>(
                propertyService.createProperty(dto),
                HttpStatus.CREATED
        );
    }
}
