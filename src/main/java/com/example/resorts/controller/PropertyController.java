package com.example.resorts.controller;

import com.example.resorts.entity.Property;
import com.example.resorts.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Get all active properties (for customers)
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getActiveProperty();
    }

    // Get property by ID
    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }
}
