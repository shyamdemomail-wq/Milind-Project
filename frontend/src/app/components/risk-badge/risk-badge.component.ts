import { Component, Input } from '@angular/core';
import { NgClass } from '@angular/common';

@Component({
    selector: 'app-risk-badge',
    standalone: true,
    imports: [NgClass],
    templateUrl: './risk-badge.component.html',
    styleUrl: './risk-badge.component.css'
})
export class RiskBadgeComponent {
    @Input() level: string = 'UNKNOWN';

    get badgeClass(): string {
        const key = (this.level || '').toUpperCase();
        const map: Record<string, string> = {
            LOW: 'badge-green',
            MEDIUM: 'badge-orange',
            HIGH: 'badge-red',
            APPROVE: 'badge-green',
            MANUAL_REVIEW: 'badge-orange',
            DENY: 'badge-red'
        };
        return map[key] || 'badge-gray';
    }
}
