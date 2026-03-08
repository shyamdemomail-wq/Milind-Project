import { Component, Input } from '@angular/core';
import { RiskBadgeComponent } from '../risk-badge/risk-badge.component';

@Component({
    selector: 'app-decision-card',
    standalone: true,
    imports: [RiskBadgeComponent],
    templateUrl: './decision-card.component.html',
    styleUrl: './decision-card.component.css'
})
export class DecisionCardComponent {
    @Input() title: string = '';
    @Input() badgeLabel: string = '';
    @Input() highlight: string = '';
    @Input() details: string = '';
}
