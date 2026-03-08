# Insurance AI Decision Platform

AI-powered insurance decision automation using Spring Boot and Anthropic Claude on the backend, with a Next.js 14+ frontend dashboard.

## System Capabilities
1. **Insurance Underwriting Quote Assistant**: Generates structured AI premium recommendations based on an applicant's risk factors.
2. **Insurance Claims Triage Assistant**: Automatically classifies claims into APPROVE, MANUAL_REVIEW, or DENY using Claude's reasoning.

## Prerequisites
- Java 21
- Node.js 18+
- Maven 3.9+
- Anthropic API Key for Claude

## Project Structure
This is a monorepo containing:
- `backend/`: Spring Boot Java application
- `frontend/`: Next.js React application

## Backend Setup (Spring Boot)

1. Navigate to the `backend/` directory:
   ```bash
   cd backend
   ```
2. Set your Anthropic API Key as an environment variable:
   - On Windows: `set ANTHROPIC_API_KEY=your_key_here`
   - On Mac/Linux: `export ANTHROPIC_API_KEY=your_key_here`
3. Download dependencies and run the application:
   ```bash
   mvn clean spring-boot:run
   ```
   *The backend will start on http://localhost:8080*

### API Endpoints & Swagger Docs
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **Underwriting**: `POST /api/ins/quote`
- **Claims Triage**: `POST /api/ins/claims/triage`

#### Example Curl Commands

**Quote Generation:**
```bash
curl -X POST http://localhost:8080/api/ins/quote \
  -H "Content-Type: application/json" \
  -d '{
    "product": "Auto",
    "age": 34,
    "location": "Hyderabad",
    "sumInsured": 800000,
    "pastClaims": 1,
    "riskFactors": "no prior DUI, city parking"
  }'
```

**Claim Triage:**
```bash
curl -X POST http://localhost:8080/api/ins/claims/triage \
  -H "Content-Type: application/json" \
  -d '{
    "product": "Auto",
    "claimAmount": 120000,
    "incidentDesc": "Rear-end collision at low speed",
    "policyTenure": 3,
    "redFlags": "none"
  }'
```

## Frontend Setup (Next.js)

1. Open a new terminal and navigate to the `frontend/` directory:
   ```bash
   cd frontend
   ```
2. Install dependencies (if you haven't already):
   ```bash
   npm install axios
   ```
3. Run the development server:
   ```bash
   npm run dev
   ```
4. Open [http://localhost:3000](http://localhost:3000) in your browser to view the Dashboard.
