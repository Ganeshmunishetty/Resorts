package com.example.resorts.entity.enums;

public enum PropertyStatus {
	ACTIVE,
	INACTIVE;
	
	public static PropertyStatus from(String value) {
        return PropertyStatus.valueOf(value.toUpperCase());
    }
}
