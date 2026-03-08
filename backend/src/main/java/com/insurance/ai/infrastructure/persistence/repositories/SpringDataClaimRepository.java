package com.insurance.ai.infrastructure.persistence.repositories;

import com.insurance.ai.infrastructure.persistence.entities.ClaimJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataClaimRepository extends JpaRepository<ClaimJpaEntity, Long> {
}
