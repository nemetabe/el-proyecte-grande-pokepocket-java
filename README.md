# PokePocket

PokePocket is a full-stack web application that combines Pokémon with personal finance management. Users can track their savings and expenses while taking care of their virtual Pokémon companion.

## Features

- User authentication and registration
- Personal finance tracking
- Virtual Pokémon companion system
- Pokémon evolution based on savings goals
- Interactive UI with modern design

## Tech Stack

### Backend
- Java 17
- Spring Boot 3.4.3
- Spring Security with JWT
- JPA/Hibernate
- PostgreSQL
- JUnit 5 & Mockito for testing

### Frontend
- React 19
- Vite
- TailwindCSS
- DaisyUI
- React Router
- Framer Motion for animations
- Recharts & ApexCharts for data visualization

## Important Note
Docker configuration is currently not working. Please follow the manual setup instructions below to run the application.

## Prerequisites

Before running the application, make sure you have the following installed:
- Java Development Kit (JDK) 17 or later
- Node.js 18 or later
- PostgreSQL 15 or later
- Maven

## Environment Setup

### Database Setup
1. Install PostgreSQL
2. Create a new database:
```sql
CREATE DATABASE poke_pocket;
```

### Backend Setup
1. Navigate to the Backend directory:
```bash
cd Backend
```

2. Create a `.env` file in the Backend directory with the following content:
```properties
DB_USERNAME=your_postgres_username
DB_PASSWORD=your_postgres_password
DB_URL=jdbc:postgresql://localhost:5432/poke_pocket
SECRET_KEY=your_jwt_secret_key
EXPIRATION=6800000
```

3. Build and run the backend:
```bash
./mvnw clean install
./mvnw spring-boot:run
```

The backend server will start on port 8082.

### Frontend Setup
1. Navigate to the Frontend/PokePocket directory:
```bash
cd Frontend/PokePocket
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

The frontend application will start on port 5173.

## Running Tests

### Backend Tests
Navigate to the Backend directory and run:
```bash
./mvnw test
```

## API Documentation

The backend provides the following main endpoints:

- `POST /api/user/register` - Register a new user
- `POST /api/user/login` - User login
- `GET /api/user/profile` - Get user profile
- `GET /api/pokemon/all` - Get all base Pokémon
- Various transaction and savings-related endpoints

