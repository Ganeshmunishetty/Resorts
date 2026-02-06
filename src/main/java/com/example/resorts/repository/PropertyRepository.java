package com.example.resorts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resorts.entity.Property;
import com.example.resorts.entity.enums.PropertyStatus;


public interface PropertyRepository extends JpaRepository<Property, Long>{

	List<Property> findByStatus(PropertyStatus status);
}
