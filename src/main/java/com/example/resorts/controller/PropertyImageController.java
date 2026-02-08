package com.example.resorts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.resorts.entity.PropertyImage;
import com.example.resorts.service.PropertyImageService;

@RestController
@RequestMapping("/api")
public class PropertyImageController {

    private final PropertyImageService imageService;

    public PropertyImageController(PropertyImageService imageService) {
        this.imageService = imageService;
    }

    // ADMIN: Add image to property
    @PostMapping("/admin/properties/{propertyId}/images")
    public ResponseEntity<PropertyImage> addImage(
            @PathVariable Long propertyId,
            @RequestBody Map<String, String> body) {

        String imageUrl = body.get("imageUrl");

        return new ResponseEntity<>(
                imageService.addImageToProperty(propertyId, imageUrl),
                HttpStatus.CREATED
        );
    }

    // PUBLIC: Get images of a property
    @GetMapping("/properties/{propertyId}/images")
    public ResponseEntity<List<PropertyImage>> getImages(
            @PathVariable Long propertyId) {

        return ResponseEntity.ok(
                imageService.getImagesByProperty(propertyId)
        );
    }
}

