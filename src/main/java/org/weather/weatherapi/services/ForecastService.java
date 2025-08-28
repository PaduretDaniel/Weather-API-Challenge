package org.weather.weatherapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.weather.weatherapi.dtos.ForecastDto;
import static org.weather.weatherapi.mappers.ForecastMapper.mapToForecastDto;

@Service
public class ForecastService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.main-url}")
    private String urlStart;

    private final HttpClient http = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();


    public ForecastDto fetchForecast(String city) throws IOException, InterruptedException {

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(urlStart + "?key=" + apiKey + "&q=" + city + "&days=2"))
                .GET()
                .build();

        HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
        JsonNode root = mapper.readTree(res.body());
        return mapToForecastDto(root);
    }

}
