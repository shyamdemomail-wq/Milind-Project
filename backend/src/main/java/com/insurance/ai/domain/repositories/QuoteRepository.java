package com.insurance.ai.domain.repositories;

import com.insurance.ai.domain.entities.InsuranceQuote;
import java.util.Optional;

public interface QuoteRepository {
    InsuranceQuote save(InsuranceQuote quote);

    Optional<InsuranceQuote> findById(Long id);
}
