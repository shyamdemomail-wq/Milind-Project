package com.insurance.ai.prompts;

public class UnderwritingPromptTemplate {

    public static final String UNDERWRITING_PROMPT = """
            You are a senior insurance underwriting analyst.

            Analyze the provided risk profile.

            Generate premium suggestions.

            Return ONLY valid JSON with fields:
            suggestedPremium
            currency
            riskBand
            underwritingNotes

            RiskBand must be LOW, MEDIUM, or HIGH.

            Risk Profile:
            Product: {product}
            Age: {age}
            Location: {location}
            Sum Insured: {sumInsured}
            Past Claims: {pastClaims}
            Risk Factors: {riskFactors}
            """;
}
