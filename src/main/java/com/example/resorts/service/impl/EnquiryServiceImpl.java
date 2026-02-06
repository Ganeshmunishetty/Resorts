package com.example.resorts.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.resorts.entity.Enquiry;
import com.example.resorts.entity.Property;
import com.example.resorts.entity.enums.EnquiryStatus;
import com.example.resorts.repository.EnquiryRepository;
import com.example.resorts.repository.PropertyRepository;
import com.example.resorts.service.EnquiryService;
@Service
public class EnquiryServiceImpl implements EnquiryService{

	private EnquiryRepository enquiryRepository;
	private PropertyRepository propertyRepository;
	public EnquiryServiceImpl(EnquiryRepository enquiryRepository,PropertyRepository propertyRepository) {
		this.enquiryRepository=enquiryRepository;
		this.propertyRepository=propertyRepository;
	}
	@Override
	public Enquiry createEnquiry(Long propertyId, Enquiry enquiry) {
		Property property=propertyRepository.findById(propertyId).orElseThrow(()->new RuntimeException("Property not Found"));
		
		enquiry.setProperty(property);
		enquiry.setStatus(EnquiryStatus.NEW);
        enquiry.setCreatedAt(LocalDateTime.now());

        return enquiryRepository.save(enquiry);

	}

	 @Override
	    public Enquiry updateQuotedPrice(Long enquiryId, Double price) {
	        Enquiry enquiry = enquiryRepository.findById(enquiryId)
	                .orElseThrow(() -> new RuntimeException("Enquiry not found"));

	        enquiry.setQuotedPrice(BigDecimal.valueOf(price));
	        enquiry.setStatus(EnquiryStatus.QUOTED);

	        return enquiryRepository.save(enquiry);
	    }

	    @Override
	    public Enquiry confirmEnquiry(Long enquiryId) {
	        Enquiry enquiry = enquiryRepository.findById(enquiryId)
	                .orElseThrow(() -> new RuntimeException("Enquiry not found"));

	        enquiry.setStatus(EnquiryStatus.CONFIRMED);
	        return enquiryRepository.save(enquiry);
	    }

}
