# weather-API

A simple RESTful Weather API built with Spring Boot. This project provides current weather data for a given city using external weather services.

## Features

- Get current weather by city name
- RESTful endpoints
- JSON responses
- Error handling for invalid requests
- Easy to extend for additional weather providers

## Technologies

- Java 17+
- Spring Boot
- Maven
- REST API
- External Weather API integration (e.g., OpenWeatherMap)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- An API key from a weather provider (e.g., [OpenWeatherMap](https://openweathermap.org/api))

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Andypj004/weather-API.git
    cd weather-API
    ```
2. Add your weather API key to `application.properties`:
    ```properties
    weather.api.key=YOUR_API_KEY
    ```
3. Build and run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

- **Get current weather by city**
    ```http
    GET /api/weather?city={cityName}
    ```
    **Example:**
    ```http
    GET /api/weather?city=London
    ```

    **Response:**
    ```json
    {
      "city": "London",
      "temperature": 15.2,
      "description": "clear sky",
      "humidity": 60
    }
    ```
