# Notary Office Service Microservice

This project is a Java microservice for managing registry office situations, duties, and notary offices. It implements a RESTful API with pagination, validation, and referential integrity, and uses Flyway for database migrations.

## Technical Requirements

- N-tier implementation
- Runs on port 9564
- Applies migrations using Flyway
- Uses Object-Oriented and other relevant architectural concepts
- Uses OpenJDK 11
- Lombok annotations (optional)
- Pagination of 10 records per page for listings
- CRUD operations with validation

## Domain Models

### Registry Office Situations
- **ID**: String (up to 20 characters, required)
- **Name**: String (up to 50 characters, required)

Initial situations via migration:
- Active (`SIT_ATIVO`)
- Blocked (`SIT_BLOQUEADO`)

### Registry Office Duties
- **ID**: String (up to 20 characters, required)
- **Name**: String (up to 50 characters, required)
- **Situation**: Boolean (default true, required)

### Notary Offices
- **ID**: Integer (greater than zero, required)
- **Name**: String (up to 150 characters, required)
- **Note**: String (up to 250 characters, optional)
- **Status**: Registry Office Situation (required)
- **Duties**: List of Registry Office Duties (at least one duty required)

## Endpoints

### Registry Office Situations

- **GET** `/api/situations`
  - List all situations

- **GET** `/api/situations/{id}`
  - Get a situation by ID

- **POST** `/api/situations`
  - Create a new situation

- **PUT** `/api/situations/{id}`
  - Update a situation by ID

- **DELETE** `/api/situations/{id}`
  - Delete a situation by ID

### Registry Office Duties

- **GET** `/api/duties`
  - List all duties

- **GET** `/api/duties/{id}`
  - Get a duty by ID

- **POST** `/api/duties`
  - Create a new duty

- **PUT** `/api/duties/{id}`
  - Update a duty by ID

- **DELETE** `/api/duties/{id}`
  - Delete a duty by ID

### Notary Offices

- **GET** `/api/notary-offices`
  - List all notary offices with pagination

- **GET** `/api/notary-offices/{id}`
  - Get a notary office by ID

- **POST** `/api/notary-offices`
  - Create a new notary office

- **PUT** `/api/notary-offices/{id}`
  - Update a notary office by ID

- **DELETE** `/api/notary-offices/{id}`
  - Delete a notary office by ID

## How to Access

1. Clone the repository:
   ```bash
   git clone https://github.com/Deivison-Costa/Scribe-Technical-Challenge
   cd notary-office-service

2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run

3. Access the application:
- Base url: `http://localhost:9564`

4. Use an API client (e.g., Postman) to interact with the endpoints.

## Next Steps
- Add comprehensive error handling
- Implement additional validation logic
- Write unit and integration tests
- Document the API using Swagger

## Tech Stack
- **Java**: OpenJDK 11
- **Spring Boot**: Web, Data JPA, DevTools
- **H2 Database**: In-memory database for development
- **Flyway**: Database migrations
- **Lombok**: Simplify Java code
- **Validation**: Bean validation for input data

## IDE used
- IntelliJ IDEA Ultimate

## List of endpoints
![1](https://github.com/Deivison-Costa/Scribe-Technical-Challenge/assets/112001225/0c376cc5-9822-4a6a-8085-7873cde678d9)

## Database
![2](https://github.com/Deivison-Costa/Scribe-Technical-Challenge/assets/112001225/2ce9c0cd-16e9-4d4e-b2ca-ea7a547802c7)
