Weather API Challenge

## A **Spring Boot console application** that fetches next-day weather forecasts for multiple cities using the [WeatherAPI.com](https://www.weatherapi.com/) service.  
The app demonstrates usage of **Spring Boot, Java HTTP Client, Jackson, and environment variable configuration**.

---

## Features
- Retrieves weather forecast for the **next day**.
- Supports multiple cities (default: `Amsterdam`, `Chisinau`, `Kyiv`, `Madrid`).
- Tabular console output:
+-----------+------------+----------+----------+----------+---------+
|    City   |    Date    | MinTempC | MaxTempC | Humidity | WindKph |
+-----------+------------+----------+----------+----------+---------+
| Amsterdam | 2025-08-30 |   13.7   |   22.2   |    70    |  24.1   |
+-----------+------------+----------+----------+----------+---------+

## Tech Stack
- Java 17+  
- Spring Boot (console app)  
- Maven  
- Jackson
- Java 11 `HttpClient`


### Setup & Installation

## 1. Clone the repository
git clone https://github.com/PaduretDaniel/Weather-API-Challenge
cd Weather-API-Challenge

## 2. Configure API Key (from https://www.weatherapi.com/)
in .env:
WEATHER_API_KEY=your_api_key_here

## 3. Build and run
mvn clean install
mvn spring-boot:run

## Project Structure
src/main/java/org/weather/weatherapi
 ├── WeatherapiApplication.java       # Main entry point
 ├── dtos/ForecastDto.java            # DTO for forecast data
 ├── mappers/ForecastMapper.java      # Maps JSON to DTO
 └── services/ForecastService.java    # Handles API requests
