# 🏥 Hospital Management System (Spring Data JPA)

A Spring Boot project focused on mastering **Hibernate** and **Spring Data JPA**. This project uses a "Test-Driven" approach to verify database logic and entity relationships before building out the API layer.

## 🚀 Features
* **Entity Mapping:** Clean implementation of `Patient` entities using Jakarta Persistence.
* **Repository Layer:** Leveraging `JpaRepository` for automated CRUD operations.
* **Cloud Database:** Fully integrated with **PostgreSQL** hosted on Neon.tech.
* **Test-First Logic:** Comprehensive database verification using JUnit 5 in the `src/test` directory.

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.rahulgudu2003.hospitalManagement.Project
│   │       ├── entity       <-- Patient Database Model
│   │       ├── repository   <-- Spring Data JPA Interfaces
│   │       └── ProjectApplication.java
│   └── resources
│       └── application.properties <-- Database Configuration
└── test
    ├── java
    │   └── com.rahulgudu2003.hospitalManagement.Project
    │       └── PatientTests.java  <-- Logic Verification
```

## 🛠️ Getting Started
1. Prerequisites
   Java 17+

Maven

PostgreSQL Driver (included in pom.xml)

2. Database Configuration
   The application connects to a Neon PostgreSQL instance. Ensure your src/main/resources/application.properties includes the following (replace placeholders with your actual credentials):
```properties
spring.datasource.url=jdbc:postgresql://<your-neon-host>/neondb?sslmode=require
spring.datasource.username=neondb_owner
spring.datasource.password=********
spring.jpa.hibernate.ddl-auto=update
```

3. Running Tests
   To run the application logic without a Controller/API, use the test suite:
```bash
./mvnw test -Dtest=PatientTests
```

🧪 Learning Progress
[x] Initialized Spring Boot Project.

[x] Configured PostgreSQL Remote Origin (Neon).

[x] Implemented JPA Entity (Patient).

[x] Created PatientRepository.

[x] Verified Database connectivity via JUnit tests.

[ ] Implement Service Layer.

[ ] Build REST Controllers.

Created by Rahul Gudu
