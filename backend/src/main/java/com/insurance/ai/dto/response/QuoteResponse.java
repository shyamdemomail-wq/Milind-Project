package com.insurance.ai.dto.response;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponse {
    private String product;
    private Double suggestedPremium;
    private String currency;
    private String riskBand;
    private String underwritingNotes;
}
