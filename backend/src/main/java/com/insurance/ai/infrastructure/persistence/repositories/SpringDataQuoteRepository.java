package com.insurance.ai.infrastructure.persistence.repositories;

import com.insurance.ai.infrastructure.persistence.entities.InsuranceQuoteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataQuoteRepository extends JpaRepository<InsuranceQuoteJpaEntity, Long> {
}
