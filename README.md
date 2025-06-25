# 🧾 PokePocket

**PokePocket** is a full-stack web application that merges personal finance tracking with the world of Pokémon. Users can log their expenses and savings while caring for a virtual Pokémon that evolves as financial goals are met.

---

## ✨ Features

- Secure user registration and login
- Track income, expenses, and savings
- Raise a virtual Pokémon that grows with your financial progress
- Evolution system linked to savings goals
- Interactive and responsive user interface

---

## 🧰 Tech Stack

### 🔧 Backend
- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Security** with **JWT**
- **JPA / Hibernate**
- **PostgreSQL**
- **JUnit 5 & Mockito** for testing

### 🎨 Frontend
- **React 19**
- **Vite**
- **TailwindCSS** + **DaisyUI**
- **React Router**
- **Framer Motion** (animations)
- **Recharts & ApexCharts** (charts and graphs)

---

## ⚠️ Docker Notice

> Docker setup is currently not functional.  
> Please proceed with the manual environment setup instructions below.

---

## ⚙️ Environment Setup

### 🗂 Environment Files

The app uses environment variables for configuration. Copy the provided `.env.example` files and rename them to `.env`:

```bash
# Root config
cp .env.example .env

# Backend config
cd Backend
cp .env.example .env

# Frontend config
cd ../Frontend/PokePocket
cp .env.example .env
```

Edit each .env with your local values (e.g., DB credentials, JWT secret, API URL).

## 🔐 Security Guidelines

- Never commit .env files to version control — they are already in .gitignore
- If secrets are accidentally pushed:
  - Remove them from Git history
  - Rotate keys immediately
  - Generate new credentials

---

## 🛢️ Database Setup

Install PostgreSQL and create the database:

```sql
CREATE DATABASE poke_pocket;
```

---

## 🖥 Backend Setup

Navigate to the backend folder:

```bash
cd Backend
```

Make sure your .env contains:

```env
DB_USERNAME=your_postgres_username
DB_PASSWORD=your_postgres_password
DB_URL=jdbc:postgresql://localhost:5432/poke_pocket
SECRET_KEY=your_jwt_secret_key
EXPIRATION=6800000
```

Then build and run:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Runs on: http://localhost:8082

---

## 🌍 Frontend Setup

Navigate to the frontend app:

```bash
cd Frontend/PokePocket
```

Install dependencies and start the dev server:

```bash
npm install
npm run dev
```

Runs on: http://localhost:5173

---

## 📡 API Endpoints

### User
- **POST** `/api/user/register` – Register a new account
- **POST** `/api/user/login` – User login
- **GET** `/api/user/profile` – Fetch logged-in user's profile

### Pokémon
- **GET** `/api/pokemon/all` – Retrieve all available Pokémon

### Finance
- Multiple endpoints for:
  - Adding/removing transactions
  - Setting savings goals
  - Viewing financial statistics

---

## 💡 Future Enhancements

- Docker support
- Mobile-friendly companion app (React Native)
- Enhanced Pokémon features (battles, personality traits, etc.)

---

## 📄 License

This project is licensed under the MIT License.
