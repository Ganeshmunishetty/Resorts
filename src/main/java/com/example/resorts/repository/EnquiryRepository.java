package com.example.resorts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resorts.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long>{

}
