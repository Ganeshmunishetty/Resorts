package com.example.resorts.service;

import java.util.List;

import com.example.resorts.entity.PropertyImage;

public interface PropertyImageService {

    PropertyImage addImageToProperty(Long propertyId, String imageUrl);

    List<PropertyImage> getImagesByProperty(Long propertyId);
}
