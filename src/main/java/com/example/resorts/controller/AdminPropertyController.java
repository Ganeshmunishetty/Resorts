package com.example.resorts.controller;


import com.example.resorts.entity.Property;
import com.example.resorts.service.PropertyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/properties")
public class AdminPropertyController {

    private final PropertyService propertyService;

    public AdminPropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // Create new property (admin only)
    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }
}
