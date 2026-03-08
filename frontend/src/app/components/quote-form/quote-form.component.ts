import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { ApiService, QuoteRequest, QuoteResponse } from '../../services/api.service';
import { DecisionCardComponent } from '../decision-card/decision-card.component';

@Component({
    selector: 'app-quote-form',
    standalone: true,
    imports: [FormsModule, NgIf, DecisionCardComponent],
    templateUrl: './quote-form.component.html',
    styleUrl: './quote-form.component.css'
})
export class QuoteFormComponent {
    formData: QuoteRequest = {
        product: 'Auto',
        age: 0,
        location: '',
        sumInsured: 0,
        pastClaims: 0,
        riskFactors: ''
    };

    result: QuoteResponse | null = null;
    loading = false;
    error: string | null = null;

    constructor(private apiService: ApiService) { }

    onSubmit(): void {
        this.loading = true;
        this.error = null;
        this.result = null;

        this.apiService.getQuote(this.formData).subscribe({
            next: (response) => {
                this.result = response;
                this.loading = false;
            },
            error: (err) => {
                this.error = err.error?.error || 'Failed to fetch quote. Please ensure backend is running.';
                this.loading = false;
            }
        });
    }

    get highlightText(): string {
        if (!this.result) return '';
        return `${this.result.suggestedPremium?.toLocaleString()} ${this.result.currency || ''}`;
    }
}
