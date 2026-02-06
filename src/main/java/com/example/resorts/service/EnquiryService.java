package com.example.resorts.service;

import com.example.resorts.entity.Enquiry;

public interface EnquiryService {

	Enquiry createEnquiry(Long propertyId, Enquiry enquiry);

	Enquiry updateQuotedPrice(Long enquiryId, Double price);

	Enquiry confirmEnquiry(Long enquiryId);
}
