package com.insurance.ai.dto.response;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaimTriageResponse {
    private String decision;
    private String reason;
    private String nextStep;
}
