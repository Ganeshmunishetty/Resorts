package com.example.resorts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.resorts.entity.Enquiry;
import com.example.resorts.service.EnquiryService;

@RestController
@RequestMapping("/api/enquiries")
public class EnquiryController {

    private final EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    // Public: Create enquiry for a property
    @PostMapping("/property/{propertyId}")
    public ResponseEntity<Enquiry> createEnquiry(
            @PathVariable Long propertyId,
            @RequestBody Enquiry enquiry) {

        return new ResponseEntity<>(
                enquiryService.createEnquiry(propertyId, enquiry),
                HttpStatus.CREATED
        );
    }

    // Admin: Quote price
    @PutMapping("/{enquiryId}/quote")
    public ResponseEntity<Enquiry> quotePrice(
            @PathVariable Long enquiryId,
            @RequestParam Double price) {

        return ResponseEntity.ok(
                enquiryService.updateQuotedPrice(enquiryId, price)
        );
    }

    // Admin: Confirm booking
    @PutMapping("/{enquiryId}/confirm")
    public ResponseEntity<Enquiry> confirmEnquiry(
            @PathVariable Long enquiryId) {

        return ResponseEntity.ok(
                enquiryService.confirmEnquiry(enquiryId)
        );
    }
}
