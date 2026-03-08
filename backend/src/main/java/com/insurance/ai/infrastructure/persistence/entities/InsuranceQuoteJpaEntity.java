package com.insurance.ai.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "insurance_quotes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceQuoteJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // From Request
    private String product;
    private Integer age;
    private String location;
    private Double sumInsured;
    private Integer pastClaims;
    @Column(length = 1000)
    private String riskFactors;

    // From Response
    private Double suggestedPremium;
    private String currency;
    private String riskBand;
    @Column(length = 2000)
    private String underwritingNotes;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
