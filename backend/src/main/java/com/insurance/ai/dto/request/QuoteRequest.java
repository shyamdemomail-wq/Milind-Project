package com.insurance.ai.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuoteRequest {
    @NotBlank(message = "Product is required")
    private String product;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Sum insured is required")
    @Min(value = 1000, message = "Sum insured must be at least 1000")
    private Double sumInsured;

    @NotNull(message = "Past claims must be specified")
    @Min(value = 0, message = "Past claims cannot be negative")
    private Integer pastClaims;

    @NotBlank(message = "Risk factors must be specified")
    private String riskFactors;
}
