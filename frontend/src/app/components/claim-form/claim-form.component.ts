import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { ApiService, ClaimTriageRequest, ClaimTriageResponse } from '../../services/api.service';
import { DecisionCardComponent } from '../decision-card/decision-card.component';

@Component({
    selector: 'app-claim-form',
    standalone: true,
    imports: [FormsModule, NgIf, DecisionCardComponent],
    templateUrl: './claim-form.component.html',
    styleUrl: './claim-form.component.css'
})
export class ClaimFormComponent {
    formData: ClaimTriageRequest = {
        product: 'Auto',
        claimAmount: 0,
        incidentDesc: '',
        policyTenure: 0,
        redFlags: 'none'
    };

    result: ClaimTriageResponse | null = null;
    loading = false;
    error: string | null = null;

    constructor(private apiService: ApiService) { }

    onSubmit(): void {
        this.loading = true;
        this.error = null;
        this.result = null;

        this.apiService.triageClaim(this.formData).subscribe({
            next: (response) => {
                this.result = response;
                this.loading = false;
            },
            error: (err) => {
                this.error = err.error?.error || 'Failed to analyze claim. Please ensure backend is running.';
                this.loading = false;
            }
        });
    }

    get detailsText(): string {
        if (!this.result) return '';
        return `${this.result.reason}\n\nNext Step: ${this.result.nextStep}`;
    }
}
