package com.insurance.ai.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClaimTriageRequest {
    @NotBlank(message = "Product is required")
    private String product;

    @NotNull(message = "Claim amount is required")
    @Min(value = 0, message = "Claim amount cannot be negative")
    private Double claimAmount;

    @NotBlank(message = "Incident description is required")
    private String incidentDesc;

    @NotNull(message = "Policy tenure is required")
    @Min(value = 0, message = "Policy tenure cannot be negative")
    private Integer policyTenure;

    @NotBlank(message = "Red flags must be specified (e.g., 'none')")
    private String redFlags;
}
