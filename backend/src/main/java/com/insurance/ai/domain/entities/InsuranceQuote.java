package com.insurance.ai.domain.entities;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceQuote {

    private Long id;

    // From Request
    private String product;
    private Integer age;
    private String location;
    private Double sumInsured;
    private Integer pastClaims;
    private String riskFactors;

    // From Response
    private Double suggestedPremium;
    private String currency;
    private String riskBand;
    private String underwritingNotes;

    private LocalDateTime createdAt;
}
