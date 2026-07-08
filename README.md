# RentalSystem / Système de location

Backend Spring Boot pour la gestion de voitures, clients et réservations.  
Spring Boot backend for managing cars, clients, and reservations.

## 🇫🇷 Français

### Description
RentalSystem est une API REST construite avec Spring Boot pour gérer un système de location de voitures, avec gestion des utilisateurs, clients, véhicules et réservations.

### Ce que fait l’application
L’application centralise le cycle complet d’une location de voiture :
- un utilisateur s’inscrit puis s’authentifie via Keycloak ;
- les administrateurs gèrent les voitures disponibles ;
- les clients sont enregistrés dans le système ;
- une réservation relie un client, une voiture et une période de location.

L’objectif est de fournir une base backend claire et sécurisée pour une plateforme de location.

### Fonctionnalités principales
- Gestion des voitures (`/voiture`)
- Gestion des réservations (`/reservation`)
- Gestion des clients (`/client`)
- Endpoints d’administration (`/admin`)
- Inscription utilisateur (`/user/register`)
- Sécurité JWT/OAuth2 avec Keycloak

### Stack technique
- Java 17
- Spring Boot 3
- Spring Security (Resource Server OAuth2/JWT)
- Spring Data JPA
- MySQL
- springdoc-openapi (Swagger UI)

### Prérequis
- Java 17+
- Maven 3.9+ (ou `mvnw`)
- MySQL
- Keycloak (realm configuré pour `rental-system`)

### Configuration
Le fichier principal de configuration est :

- `/home/runner/work/RentalSystem/RentalSystem/src/main/resources/application.properties`

Pense à adapter les paramètres suivants à ton environnement :
- Base de données (`spring.datasource.*`)
- Keycloak/JWT (`spring.security.oauth2.resourceserver.jwt.*`)
- SMTP (`spring.mail.*`)

### Lancer le projet
```bash
mvn spring-boot:run
```

### Exécuter les tests
```bash
mvn test
```

### Documentation API
Une fois l’application lancée :
- Swagger UI : `http://localhost:8080/api/v1/swagger-ui/index.html`

---

## 🇬🇧 English

### Description
RentalSystem is a Spring Boot REST API for managing a car rental workflow, including users, clients, vehicles, and reservations.

### What the application does
The application covers the full car-rental lifecycle:
- users register and authenticate through Keycloak;
- administrators manage available cars;
- clients are stored and managed in the system;
- reservations link a client, a car, and a rental period.

The goal is to provide a clear and secure backend foundation for a rental platform.

### Main features
- Car management (`/voiture`)
- Reservation management (`/reservation`)
- Client management (`/client`)
- Admin endpoints (`/admin`)
- User registration (`/user/register`)
- JWT/OAuth2 security with Keycloak

### Tech stack
- Java 17
- Spring Boot 3
- Spring Security (OAuth2/JWT Resource Server)
- Spring Data JPA
- MySQL
- springdoc-openapi (Swagger UI)

### Prerequisites
- Java 17+
- Maven 3.9+ (or `mvnw`)
- MySQL
- Keycloak (realm configured for `rental-system`)

### Configuration
Main configuration file:

- `/home/runner/work/RentalSystem/RentalSystem/src/main/resources/application.properties`

Update these settings for your environment:
- Database (`spring.datasource.*`)
- Keycloak/JWT (`spring.security.oauth2.resourceserver.jwt.*`)
- SMTP (`spring.mail.*`)

### Run the project
```bash
mvn spring-boot:run
```

### Run tests
```bash
mvn test
```

### API documentation
After starting the application:
- Swagger UI: `http://localhost:8080/api/v1/swagger-ui/index.html`
