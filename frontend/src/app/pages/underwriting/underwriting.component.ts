import { Component } from '@angular/core';
import { QuoteFormComponent } from '../../components/quote-form/quote-form.component';

@Component({
    selector: 'app-underwriting',
    standalone: true,
    imports: [QuoteFormComponent],
    templateUrl: './underwriting.component.html',
    styleUrl: './underwriting.component.css'
})
export class UnderwritingComponent { }
