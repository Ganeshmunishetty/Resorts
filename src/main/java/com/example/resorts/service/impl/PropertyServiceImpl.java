package com.example.resorts.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resorts.entity.Property;
import com.example.resorts.entity.enums.PropertyStatus;
import com.example.resorts.repository.PropertyRepository;
import com.example.resorts.service.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService {

	final PropertyRepository propertyRepository;
	
	public PropertyServiceImpl(PropertyRepository propertyRepository) {
		this.propertyRepository=propertyRepository;
	}
	@Override
	public Property createProperty(Property property) {
		property.setStatus(PropertyStatus.ACTIVE);
        property.setCreatedAt(LocalDateTime.now());
        return propertyRepository.save(property);
	}

	@Override
	public List<Property> getActiveProperty() {
		 return propertyRepository.findByStatus(PropertyStatus.ACTIVE);
	}

	@Override
	public Property getPropertyById(Long id) {
		 return propertyRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Property not found"));
	   
	}

}
