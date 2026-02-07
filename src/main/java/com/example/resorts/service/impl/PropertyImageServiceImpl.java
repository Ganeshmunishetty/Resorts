package com.example.resorts.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resorts.entity.Property;
import com.example.resorts.entity.PropertyImage;
import com.example.resorts.exception.ResourceNotFoundException;
import com.example.resorts.repository.PropertyImageRepository;
import com.example.resorts.repository.PropertyRepository;
import com.example.resorts.service.PropertyImageService;

@Service
public class PropertyImageServiceImpl implements PropertyImageService {

    private final PropertyRepository propertyRepository;
    private final PropertyImageRepository imageRepository;

    public PropertyImageServiceImpl(PropertyRepository propertyRepository,
                                    PropertyImageRepository imageRepository) {
        this.propertyRepository = propertyRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public PropertyImage addImageToProperty(Long propertyId, String imageUrl) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        PropertyImage image = new PropertyImage();
        image.setImageUrl(imageUrl);
        image.setProperty(property);

        return imageRepository.save(image);
    }

    @Override
    public List<PropertyImage> getImagesByProperty(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        return property.getImages();
    }
}
