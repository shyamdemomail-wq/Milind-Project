import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UnderwritingComponent } from './pages/underwriting/underwriting.component';
import { ClaimsComponent } from './pages/claims/claims.component';

export const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'underwriting', component: UnderwritingComponent },
    { path: 'claims', component: ClaimsComponent },
    { path: '**', redirectTo: '/dashboard' }
];
