package com.insurance.ai.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClaimJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // From Request
    private String product;
    private Double claimAmount;
    @Column(length = 1000)
    private String incidentDesc;
    private Integer policyTenure;
    private String redFlags;

    // From Response
    private String decision;
    @Column(length = 2000)
    private String reason;
    @Column(length = 1000)
    private String nextStep;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
