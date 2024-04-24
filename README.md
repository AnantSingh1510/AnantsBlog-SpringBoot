# Spring Boot Application with PostgreSQL Database

This is a sample Spring Boot application configured to work with a PostgreSQL database hosted on Render.com.

## Overview

The application demonstrates how to connect a Spring Boot application to a PostgreSQL database using Spring Data JPA. It includes basic configuration settings and dependencies required to establish the connection.

## Requirements

To run this application locally, you need the following:

- Java Development Kit (JDK) 17 or higher
- Maven or Gradle build tool
- PostgreSQL database (local or hosted)

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/AnantSingh1510/AnantsBlog-SpringBoot.git
   ```

2. Navigate to the project directory:

   ```bash
   cd your-repository
   ```

3. Update the `application.properties` or `application.yml` file with your PostgreSQL database connection details:

   ```properties
   spring.datasource.url=jdbc:postgresql://your-render-postgres-host:5432/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

4. Build the application using Maven or Gradle:

   ```bash
   # For Maven
   mvn clean package

   # For Gradle
   ./gradlew clean build
   ```

5. Run the application:

   ```bash
   # For Maven
   mvn spring-boot:run

   # For Gradle
   ./gradlew bootRun
   ```

6. Access the application at `http://localhost:8080` in your web browser.

## Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
