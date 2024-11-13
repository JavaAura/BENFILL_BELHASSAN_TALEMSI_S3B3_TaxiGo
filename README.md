# Taxi Management System API

## Project Description
This project provides a RESTful API for managing the digital operations of a taxi company. It enables comprehensive management of bookings, drivers, vehicles, and trip tracking, supporting the digital transformation of taxi service operations. 

## General Objective
The primary goal of this application is to streamline taxi service management, ensuring efficient handling of:
- Reservations (creation, modification, cancellation, and display)
- Drivers (availability, assignment, and status management)
- Vehicles (assignment, status, and analytics)
- Analytics and reporting for improved operational insights

## Key Features
1. **Reservation Management**  
   - CRUD operations for reservations
   - Price calculation based on distance and vehicle type
   - Availability checks for drivers and vehicles
   - Status management for reservations (CREATED, CONFIRMED, COMPLETED, CANCELLED)

2. **Driver Management**  
   - Availability tracking
   - Restrictions ensuring each driver handles only one vehicle and one active reservation at a time
   - Status management (AVAILABLE, IN_TRIP, UNAVAILABLE)

3. **Vehicle Management**  
   - Type-based pricing (e.g., Sedan, Van, Minibus)
   - Restrictions ensuring each vehicle has only one active reservation at a time
   - Status management and analytics

4. **Analytics and Statistics**  
   - Detailed analytics endpoints for reservations, drivers, and vehicles, offering insights such as:
     - Average price per kilometer
     - Distribution of reservations by time slot
     - Demand analysis by geographic zones

## Technologies Used
- **Backend**: Spring Boot, RESTful API
- **Database**: H2 (dev), MySQL (QA), PostgreSQL (prod), Liquibase for database migrations
- **Tools**: Swagger for API documentation, Postman for API testing, Git, JIRA, SonarLint, Lombok, Spring Boot DevTools
- **Testing**: JUnit, Mockito for unit and integration testing

## Project Structure
The project follows a layered architecture consisting of:
- **Controller Layer**: Manages RESTful endpoints
- **Service Layer**: Business logic and validation
- **Repository/DAO Layer**: Data access and complex queries
- **Model Layer**: Entity classes representing reservations, drivers, and vehicles
- **DTOs and Mappers**: For data transfer objects and transformations
- **Utility Layer**: Logging, exception handling, and validation utilities

## Installation and Usage Instructions

### Prerequisites
- Java 8 or later
- Maven
- A preferred IDE (e.g., IntelliJ, Eclipse)
- Git for version control

### Database Configuration
The application supports different profiles for development, QA, and production:
1. **Development (H2 Database)**: Configure in `application-dev.yaml`
2. **QA (MySQL Database)**: Configure in `application-qa.yaml`
3. **Production (PostgreSQL Database)**: Configure in `application-prod.yaml`

Database migrations are managed by **Liquibase**, ensuring consistent database structure across environments.

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/Benfil/TaxiGo.git
   ```
2. Navigate to the project directory:
   ```bash
   cd TaxiGo
   ```
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Access the API documentation at:
   ```
   http://localhost:8080/swagger-ui.html
   ```

### Deploying on Tomcat
1. Package the application as a WAR file:
   ```bash
   mvn clean package -DskipTests
   ```
2. Deploy the WAR file to your Tomcat server's webapps directory.
3. Start the Tomcat server and access the application.

## Future Enhancements
- **Enhanced Analytics**: Add predictive analysis based on historical data.
- **Driver and Vehicle Notifications**: Real-time updates for drivers and vehicle tracking.
- **Multi-language Support**: Enable localization for broader usability.
- **Mobile Integration**: Integrate mobile access for easier driver and customer interaction.

## Collaborators
- **Anass Benfillous - Abdellah Talemsi - Anouar Belhassan**  
For questions, contact at: [anass.benfillous@example.com](mailto:anass.benfillous@example.com)

## Useful Links
- [GitHub Repository](https://github.com/Benfil/TaxiGo)
- [JIRA Project Board](https://benfill.atlassian.net/jira/software/projects/TAX/boards/203?atlOrigin=eyJpIjoiMDg2NTc2MTE1ZDIzNDk0Y2I1NmRiODIwMjFhMjVlMTkiLCJwIjoiaiJ9)
- [Swagger UI Documentation](http://localhost:8080/swagger-ui)
- [API Docs (OpenAPI)](http://localhost:8080/v2/api-docs)
- [Postman Collection](https://www.postman.com/crimson-crescent-536061/workspace/benfill-workspace/collection/30811349-9b737d7f-54c8-4e35-a6b7-37ff4d4ad4ea?action=share&creator=30811349)
