package com.insurance.ai.domain.entities;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    private Long id;

    // From Request
    private String product;
    private Double claimAmount;
    private String incidentDesc;
    private Integer policyTenure;
    private String redFlags;

    // From Response
    private String decision;
    private String reason;
    private String nextStep;

    private LocalDateTime createdAt;
}

