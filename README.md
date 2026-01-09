# Aura - Define Your Vibe

An app to define your vibe - Track and manage your daily panoramic experiences.

## Overview

Aura is a full-stack web application that allows users to track their daily vibes by associating them with panoramic themes. Built with Spring Boot backend and React frontend, it provides a comprehensive system for managing user experiences over time.

## Technology Stack

### Backend
- **Framework**: Spring Boot 4.0.1
- **Language**: Java 21
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Build Tool**: Maven

### Frontend
- **Framework**: React 19.2.3
- **UI Library**: Bootstrap 5.3.8
- **Build Tool**: Create React App (react-scripts 5.0.1)
- **Testing**: Jest, React Testing Library

## Architecture

### Backend Structure
```
src/main/java/com/winterflame/aura/
├── entity/           # JPA entities (User, Vibe, Panorama)
├── repository/       # Spring Data JPA repositories
├── service/          # Business logic layer
└── controller/       # REST API endpoints
```

### Frontend Structure
```
react-ui/src/
├── components/       # React components
│   ├── Header/
│   ├── MainContent/
│   └── MonthlyCalendar/
└── App.js           # Main application component
```

## Data Model

- **User**: Stores user information (username, email, name)
- **Panorama**: Defines panoramic themes/categories
- **Vibe**: Tracks user vibes linked to panoramas with timestamps

## API Endpoints

### Configuration
- `GET /api/configuration/years` - Get available years

### Vibe Management
- `POST /api/vibe` - Create new vibe
- `GET /api/vibe` - Get all vibes
- `GET /api/vibe/{id}` - Get vibe by ID
- `PUT /api/vibe/{id}` - Update vibe
- `DELETE /api/vibe/{id}` - Delete vibe

## Build & Run

### Backend (Port 5000)
```bash
./mvnw spring-boot:run
```

### Frontend (Development)
```bash
cd react-ui
npm install
npm start
```

### Full Build
```bash
./mvnw clean package
```
This builds both backend and frontend, with React build integrated into Spring Boot.

## Configuration

Configure database connection in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vibe_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Features

- 📅 Monthly calendar view for tracking vibes
- 👤 User management system
- 🎨 Panoramic theme categorization
- 📊 Year-based data filtering
- 🔄 Full CRUD operations for vibes
- 💾 MySQL persistence layer

## License

This project is part of the Winterflame suite of applications.
