package com.insurance.ai.infrastructure.persistence.adapters;

import com.insurance.ai.domain.entities.InsuranceQuote;
import com.insurance.ai.domain.repositories.QuoteRepository;
import com.insurance.ai.infrastructure.persistence.entities.InsuranceQuoteJpaEntity;
import com.insurance.ai.infrastructure.persistence.repositories.SpringDataQuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QuoteRepositoryAdapter implements QuoteRepository {

    private final SpringDataQuoteRepository springDataQuoteRepository;

    @Override
    public InsuranceQuote save(InsuranceQuote quote) {
        InsuranceQuoteJpaEntity jpaEntity = toJpaEntity(quote);
        InsuranceQuoteJpaEntity savedJpaEntity = springDataQuoteRepository.save(jpaEntity);
        return toDomainEntity(savedJpaEntity);
    }

    @Override
    public Optional<InsuranceQuote> findById(Long id) {
        return springDataQuoteRepository.findById(id).map(this::toDomainEntity);
    }

    private InsuranceQuoteJpaEntity toJpaEntity(InsuranceQuote quote) {
        if (quote == null)
            return null;
        return InsuranceQuoteJpaEntity.builder()
                .id(quote.getId())
                .product(quote.getProduct())
                .age(quote.getAge())
                .location(quote.getLocation())
                .sumInsured(quote.getSumInsured())
                .pastClaims(quote.getPastClaims())
                .riskFactors(quote.getRiskFactors())
                .suggestedPremium(quote.getSuggestedPremium())
                .currency(quote.getCurrency())
                .riskBand(quote.getRiskBand())
                .underwritingNotes(quote.getUnderwritingNotes())
                .createdAt(quote.getCreatedAt())
                .build();
    }

    private InsuranceQuote toDomainEntity(InsuranceQuoteJpaEntity jpaEntity) {
        if (jpaEntity == null)
            return null;
        return InsuranceQuote.builder()
                .id(jpaEntity.getId())
                .product(jpaEntity.getProduct())
                .age(jpaEntity.getAge())
                .location(jpaEntity.getLocation())
                .sumInsured(jpaEntity.getSumInsured())
                .pastClaims(jpaEntity.getPastClaims())
                .riskFactors(jpaEntity.getRiskFactors())
                .suggestedPremium(jpaEntity.getSuggestedPremium())
                .currency(jpaEntity.getCurrency())
                .riskBand(jpaEntity.getRiskBand())
                .underwritingNotes(jpaEntity.getUnderwritingNotes())
                .createdAt(jpaEntity.getCreatedAt())
                .build();
    }
}
