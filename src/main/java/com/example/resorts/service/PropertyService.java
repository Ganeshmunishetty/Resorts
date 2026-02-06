package com.example.resorts.service;

import java.util.List;

import com.example.resorts.entity.Property;

public interface PropertyService {

	Property createProperty(Property property);

	List<Property> getActiveProperty();

	Property getPropertyById(Long id);
}
