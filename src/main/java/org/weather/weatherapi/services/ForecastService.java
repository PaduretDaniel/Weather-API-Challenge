package org.weather.weatherapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.weather.weatherapi.dtos.ForecastDto;

@Service
public class ForecastService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final HttpClient http = HttpClient.newHttpClient();
    private HttpResponse<String> res;

    private final String urlStart = "http://api.weatherapi.com/v1/forecast.json";
    private final ObjectMapper mapper = new ObjectMapper();


    public void fetchForecast(String city){
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(urlStart + "?key=" + apiKey + "&q=" + city + "&days=2"))
                .GET()
                .build();
        try {
            res = http.send(req, HttpResponse.BodyHandlers.ofString());
            JsonNode root = mapper.readTree(res.body());
            System.out.println(mapToForecastDto(root));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ForecastDto mapToForecastDto(JsonNode root){
        ForecastDto forecastDto = new ForecastDto();
        forecastDto.setCity(root.path("location").path("name").asText());
        forecastDto.setDate(LocalDate.parse(root.path("forecast").path("forecastday").get(1).path("date").asText()));
        JsonNode tomorrow = root.path("forecast").path("forecastday").get(1).path("day");
        forecastDto.setMinTempC(tomorrow.path("mintemp_c").asDouble());
        forecastDto.setMaxTempC(tomorrow.path("maxtemp_c").asDouble());
        forecastDto.setHumidity(tomorrow.path("avghumidity").asLong());
        forecastDto.setWindKph(tomorrow.path("maxwind_kph").asDouble());
        //forecastDto.setWindDir(tomorrow.path("wind_dir").asText()); Data is only specified per-hour basis.
        return forecastDto;
    }
}
