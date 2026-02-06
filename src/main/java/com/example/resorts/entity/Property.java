package com.example.resorts.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.resorts.entity.enums.EnquiryStatus;
import com.example.resorts.entity.enums.PropertyStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String location;
	@Column(length = 2000)
	private String description;
	private String amenities;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private PropertyStatus status;
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy="property",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<PropertyImage> images;
	
	
	
}
