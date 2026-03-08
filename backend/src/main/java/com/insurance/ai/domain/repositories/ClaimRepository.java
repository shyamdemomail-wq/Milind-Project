package com.insurance.ai.domain.repositories;

import com.insurance.ai.domain.entities.Claim;
import java.util.Optional;

public interface ClaimRepository {
    Claim save(Claim claim);

    Optional<Claim> findById(Long id);
}
