import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface QuoteRequest {
    product: string;
    age: number;
    location: string;
    sumInsured: number;
    pastClaims: number;
    riskFactors: string;
}

export interface QuoteResponse {
    product: string;
    suggestedPremium: number;
    currency: string;
    riskBand: string;
    underwritingNotes: string;
}

export interface ClaimTriageRequest {
    product: string;
    claimAmount: number;
    incidentDesc: string;
    policyTenure: number;
    redFlags: string;
}

export interface ClaimTriageResponse {
    decision: string;
    reason: string;
    nextStep: string;
}

@Injectable({ providedIn: 'root' })
export class ApiService {
    private readonly baseUrl = 'http://localhost:8080/api/ins';

    constructor(private http: HttpClient) { }

    getQuote(request: QuoteRequest): Observable<QuoteResponse> {
        return this.http.post<QuoteResponse>(`${this.baseUrl}/quote`, request);
    }

    triageClaim(request: ClaimTriageRequest): Observable<ClaimTriageResponse> {
        return this.http.post<ClaimTriageResponse>(`${this.baseUrl}/claims/triage`, request);
    }
}
