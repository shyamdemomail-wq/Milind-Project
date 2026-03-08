package com.insurance.ai.infrastructure.persistence.adapters;

import com.insurance.ai.domain.entities.Claim;
import com.insurance.ai.domain.repositories.ClaimRepository;
import com.insurance.ai.infrastructure.persistence.entities.ClaimJpaEntity;
import com.insurance.ai.infrastructure.persistence.repositories.SpringDataClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClaimRepositoryAdapter implements ClaimRepository {

    private final SpringDataClaimRepository springDataClaimRepository;

    @Override
    public Claim save(Claim claim) {
        ClaimJpaEntity jpaEntity = toJpaEntity(claim);
        ClaimJpaEntity savedJpaEntity = springDataClaimRepository.save(jpaEntity);
        return toDomainEntity(savedJpaEntity);
    }

    @Override
    public Optional<Claim> findById(Long id) {
        return springDataClaimRepository.findById(id).map(this::toDomainEntity);
    }

    private ClaimJpaEntity toJpaEntity(Claim claim) {
        if (claim == null)
            return null;
        return ClaimJpaEntity.builder()
                .id(claim.getId())
                .product(claim.getProduct())
                .claimAmount(claim.getClaimAmount())
                .incidentDesc(claim.getIncidentDesc())
                .policyTenure(claim.getPolicyTenure())
                .redFlags(claim.getRedFlags())
                .decision(claim.getDecision())
                .reason(claim.getReason())
                .nextStep(claim.getNextStep())
                .createdAt(claim.getCreatedAt())
                .build();
    }

    private Claim toDomainEntity(ClaimJpaEntity jpaEntity) {
        if (jpaEntity == null)
            return null;
        return Claim.builder()
                .id(jpaEntity.getId())
                .product(jpaEntity.getProduct())
                .claimAmount(jpaEntity.getClaimAmount())
                .incidentDesc(jpaEntity.getIncidentDesc())
                .policyTenure(jpaEntity.getPolicyTenure())
                .redFlags(jpaEntity.getRedFlags())
                .decision(jpaEntity.getDecision())
                .reason(jpaEntity.getReason())
                .nextStep(jpaEntity.getNextStep())
                .createdAt(jpaEntity.getCreatedAt())
                .build();
    }
}
