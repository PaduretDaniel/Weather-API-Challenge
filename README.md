Weather API Challenge

## A **Spring Boot console application** that fetches next-day weather forecasts for multiple cities using the [WeatherAPI.com](https://www.weatherapi.com/) service.  
The app demonstrates usage of **Spring Boot, Java HTTP Client, Jackson, and environment variable configuration**.

---

## Features
- Retrieves weather forecast for the **next day**.
- Supports multiple cities (default: `Amsterdam`, `Chisinau`, `Kyiv`, `Madrid`).

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
