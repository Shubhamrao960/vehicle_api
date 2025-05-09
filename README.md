#  RTO Vehicle Management API

A RESTful API built with Spring Boot and MySQL to manage vehicle records in a Regional Transport Office (RTO). This system allows you to perform basic CRUD operations and advanced filtering via RESTful endpoints.

## 🚀 Features
- Add, view, update, and delete vehicle records
- Unique registration number validation
- Search vehicles by fuel type, city, or state
- MySQL database integration
- Layered architecture (Controller, Service, Repository)
- Ready for Postman testing

## 🛠️ Technologies Used
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

## 📂 Project Structure
```
vehicle-api/
├── controller/
│   └── VehicleController.java
├── entity/
│   └── Vehicle.java
├── service/
│   └── VehicleService.java
├── repository/
│   └── VehicleRepository.java
├── exception/
│   └── ResourceNotFoundException.java
├── VehicleApiApplication.java
└── resources/
    ├── application.properties
```

## ⚙️ MySQL Configuration
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 📦 API Endpoints

### ➕ Add Vehicle
**POST** `/api/add/vehicle`  
**Request Body:**
```json
{
  "name": "Maruti Swift",
  "fuel_type": "Petrol",
  "registration_no": "AS01AB1234",
  "owner_name": "Rahul Sharma",
  "owner_address": "Guwahati",
  "city": "Guwahati",
  "state": "Assam"
}
```

### 📋 Get All Vehicles
**GET** `/api/vehicles`

### 🔍 Get Vehicle by ID
**GET** `/api/vehicle/{id}`

### ✏️ Update Vehicle
**PUT** `/api/vehicle/{id}`  
**Request Body:**
```json
{
  "name": "Tata Punch",
  "fuel_type": "Petrol",
  "registration_no": "AS01AB1234",
  "owner_name": "Rahul Sharma",
  "owner_address": "Silchar",
  "city": "Silchar",
  "state": "Assam"
}
```

### ❌ Delete Vehicle
**DELETE** `/api/vehicle/{id}`

### 🔎 Search Vehicles
- By Fuel Type: `GET /api/vehicles/search?fuel=Petrol`
- By City: `GET /api/vehicles/search?city=Guwahati`
- By State: `GET /api/vehicles/search?state=Assam`

## 🧪 Error Responses
- `404 Not Found` – Vehicle not found
- `409 Conflict` – Duplicate registration number
- `400 Bad Request` – Validation errors or missing fields

## 🏁 Getting Started

### ✅ Prerequisites
- Java 17+
- Maven
- MySQL running locally

Access the API at: `http://localhost:8080/api/vehicles`

## 📌 Future Enhancements
- Swagger/OpenAPI documentation
- Spring Security-based login
- User-specific vehicle records
- Docker + Docker Compose
- React/Angular frontend

## 🤝 Contributing
Pull requests are welcome. For major changes, open an issue first to discuss what you'd like to change.

