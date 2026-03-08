import * as apiClient from '../infrastructure/apiClient';
import { createRequestQuoteUseCase, createSubmitClaimTriageUseCase } from '../application/insuranceService';

// Composition Root: Injecting the infrastructure dependencies into the application use cases
const requestQuote = createRequestQuoteUseCase(apiClient);
const submitClaimTriage = createSubmitClaimTriageUseCase(apiClient);

// Re-exporting for backward compatibility with existing frontend UI components
export const getQuote = requestQuote;
export const triageClaim = submitClaimTriage;
