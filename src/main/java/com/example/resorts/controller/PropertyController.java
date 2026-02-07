package com.example.resorts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.resorts.dto.PropertyRequestDto;
import com.example.resorts.dto.PropertyResponseDto;
import com.example.resorts.service.PropertyService;


@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<PropertyResponseDto>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllActiveProperties());
    }

    @PostMapping
    public ResponseEntity<PropertyResponseDto> createProperty(
            @RequestBody PropertyRequestDto dto) {

        return new ResponseEntity<>(
                propertyService.createProperty(dto),
                HttpStatus.CREATED
        );
    }
}
