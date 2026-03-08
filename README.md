# 🛡️ Insurance AI Decision Platform

An intelligent insurance platform powered by **Anthropic Claude AI** for real-time underwriting risk assessment and automated claims triage.

## Architecture

| Layer | Technology |
|-------|-----------|
| **Frontend** | Angular 21 (Standalone Components) |
| **Backend API** | Java 21 + Spring Boot 3.4 |
| **AI Engine** | Anthropic Claude Sonnet 4.6 via Spring AI |
| **Database** | H2 (in-memory, dev) / PostgreSQL (prod) |
| **Build** | Maven (backend) · npm (frontend) |

## Features

### Underwriting Intelligence
- AI-powered risk band classification (LOW / MEDIUM / HIGH / CRITICAL)
- Instant premium recommendations based on applicant profile
- Detailed underwriting notes with reasoning

### Smart Claims Triage
- Automated claim decision engine (APPROVE / REVIEW / DENY)
- Fraud flag detection and severity scoring
- Recommended next steps for claims adjusters

## Quick Start

### Prerequisites
- Java 21+
- Node.js 18+
- Anthropic API Key

### 1. Start the Backend
```bash
cd backend
set ANTHROPIC_API_KEY=your-api-key-here
mvn spring-boot:run
```
Backend runs on `http://localhost:8080`

### 2. Start the Frontend
```bash
cd frontend
npm install
npx ng serve
```
Frontend runs on `http://localhost:4200`

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/ins/quote` | Generate AI underwriting quote |
| `POST` | `/api/ins/claims/triage` | Analyze and triage a claim |

## Project Structure
```
insurance-ai-platform/
├── backend/                    # Spring Boot API
│   ├── src/main/java/com/insurance/ai/
│   │   ├── api/                # REST Controllers
│   │   ├── application/        # Business Services
│   │   ├── domain/             # Entities & Repositories
│   │   ├── infrastructure/     # AI Client & JPA Adapters
│   │   ├── dto/                # Request/Response DTOs
│   │   └── prompts/            # AI Prompt Templates
│   └── src/main/resources/
│       └── application.yml     # Configuration
├── frontend/                   # Angular 21 SPA
│   └── src/app/
│       ├── components/         # Reusable UI Components
│       ├── pages/              # Route Pages
│       └── services/           # API Service Layer
└── README.md
```
