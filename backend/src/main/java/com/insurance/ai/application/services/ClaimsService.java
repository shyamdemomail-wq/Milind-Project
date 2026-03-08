package com.insurance.ai.application.services;

import com.insurance.ai.dto.request.ClaimTriageRequest;
import com.insurance.ai.dto.response.ClaimTriageResponse;
import com.insurance.ai.application.ports.AiServicePort;
import com.insurance.ai.domain.entities.Claim;
import com.insurance.ai.domain.repositories.ClaimRepository;
import com.insurance.ai.prompts.ClaimsPromptTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClaimsService {

    private final AiServicePort aiServicePort;
    private final ClaimRepository claimRepository;

    public ClaimTriageResponse triageClaim(ClaimTriageRequest request) {
        log.info("Triaging claim for product: {}", request.getProduct());

        Map<String, Object> variables = Map.of(
                "product", request.getProduct(),
                "claimAmount", request.getClaimAmount(),
                "incidentDesc", request.getIncidentDesc(),
                "policyTenure", request.getPolicyTenure(),
                "redFlags", request.getRedFlags());

        ClaimTriageResponse aiResponse = aiServicePort.callAiAndParse(
                ClaimsPromptTemplate.CLAIMS_PROMPT,
                variables,
                ClaimTriageResponse.class);

        Claim claimEntity = Claim.builder()
                .product(request.getProduct())
                .claimAmount(request.getClaimAmount())
                .incidentDesc(request.getIncidentDesc())
                .policyTenure(request.getPolicyTenure())
                .redFlags(request.getRedFlags())
                .decision(aiResponse.getDecision())
                .reason(aiResponse.getReason())
                .nextStep(aiResponse.getNextStep())
                .build();

        claimRepository.save(claimEntity);

        return aiResponse;
    }
}
