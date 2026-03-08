package com.insurance.ai.application.services;

import com.insurance.ai.dto.request.QuoteRequest;
import com.insurance.ai.dto.response.QuoteResponse;
import com.insurance.ai.application.ports.AiServicePort;
import com.insurance.ai.domain.entities.InsuranceQuote;
import com.insurance.ai.domain.repositories.QuoteRepository;
import com.insurance.ai.prompts.UnderwritingPromptTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuoteService {

    private final AiServicePort aiServicePort;
    private final QuoteRepository quoteRepository;

    public QuoteResponse generateQuote(QuoteRequest request) {
        log.info("Generating quote for product: {}", request.getProduct());

        Map<String, Object> variables = Map.of(
                "product", request.getProduct(),
                "age", request.getAge(),
                "location", request.getLocation(),
                "sumInsured", request.getSumInsured(),
                "pastClaims", request.getPastClaims(),
                "riskFactors", request.getRiskFactors());

        QuoteResponse aiResponse = aiServicePort.callAiAndParse(
                UnderwritingPromptTemplate.UNDERWRITING_PROMPT,
                variables,
                QuoteResponse.class);

        InsuranceQuote quoteEntity = InsuranceQuote.builder()
                .product(request.getProduct())
                .age(request.getAge())
                .location(request.getLocation())
                .sumInsured(request.getSumInsured())
                .pastClaims(request.getPastClaims())
                .riskFactors(request.getRiskFactors())
                .suggestedPremium(aiResponse.getSuggestedPremium())
                .currency(aiResponse.getCurrency())
                .riskBand(aiResponse.getRiskBand())
                .underwritingNotes(aiResponse.getUnderwritingNotes())
                .build();

        quoteRepository.save(quoteEntity);

        return aiResponse;
    }
}
