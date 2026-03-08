package com.insurance.ai.api.controllers;

import com.insurance.ai.application.services.QuoteService;
import com.insurance.ai.dto.request.QuoteRequest;
import com.insurance.ai.dto.response.QuoteResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ins/quote")
@RequiredArgsConstructor
public class UnderwritingController {

    private final QuoteService quoteService;

    @PostMapping
    public ResponseEntity<QuoteResponse> generateQuote(@Valid @RequestBody QuoteRequest request) {
        QuoteResponse response = quoteService.generateQuote(request);
        return ResponseEntity.ok(response);
    }
}
