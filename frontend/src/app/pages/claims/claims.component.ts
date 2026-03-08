import { Component } from '@angular/core';
import { ClaimFormComponent } from '../../components/claim-form/claim-form.component';

@Component({
    selector: 'app-claims',
    standalone: true,
    imports: [ClaimFormComponent],
    templateUrl: './claims.component.html',
    styleUrl: './claims.component.css'
})
export class ClaimsComponent { }
