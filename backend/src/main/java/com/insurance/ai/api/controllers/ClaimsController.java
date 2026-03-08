package com.insurance.ai.api.controllers;

import com.insurance.ai.application.services.ClaimsService;
import com.insurance.ai.dto.request.ClaimTriageRequest;
import com.insurance.ai.dto.response.ClaimTriageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ins/claims/triage")
@RequiredArgsConstructor
public class ClaimsController {

    private final ClaimsService claimsService;

    @PostMapping
    public ResponseEntity<ClaimTriageResponse> triageClaim(@Valid @RequestBody ClaimTriageRequest request) {
        ClaimTriageResponse response = claimsService.triageClaim(request);
        return ResponseEntity.ok(response);
    }
}
