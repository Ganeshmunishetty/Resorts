package com.example.resorts.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.resorts.entity.enums.EnquiryStatus;

import com.example.resorts.entity.enums.EnquiryStatus;

@Entity
@Table(name = "enquiries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String phone;

    private String email;

    private LocalDate checkIn;
    private LocalDate checkOut;

    private Integer guests;

    @Column(length = 1000)
    private String message;

    private BigDecimal quotedPrice;

    @Enumerated(EnumType.STRING)
    private EnquiryStatus status;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;
}
