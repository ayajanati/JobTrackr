# JobTrackr

A backend application to track internship and job applications:
company, role, status, and dates, all through a REST API.

## Tech
Java 11, Spring Boot 2.7, Spring Data JPA, H2

## Run
Run `JobtrackrApplication` from your IDE, or `./mvnw spring-boot:run`.
API base URL: http://localhost:8080/api/applications

## Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/applications | Create |
| GET | /api/applications | List all |
| GET | /api/applications/{id} | Get one |
| PUT | /api/applications/{id} | Update |
| DELETE | /api/applications/{id} | Delete |

## Roadmap
DTOs and validation, pagination and filtering, PostgreSQL, status history, JWT auth, frontend, tests, CI.
