package com.example.resorts.dto;

import com.example.resorts.entity.enums.PropertyStatus;

public class PropertyResponseDto {

	private Long id;
	private String name;
	private String location;
	private PropertyStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public PropertyStatus getStatus() {
		return status;
	}

	public void setStatus(PropertyStatus status) {
		this.status = status;
	}

	// getters & setters

}
