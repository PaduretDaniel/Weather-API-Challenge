package org.weather.weatherapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ForecastService {
    private final HttpClient http = HttpClient.newHttpClient();
    HttpResponse<String> res;
    private final String urlStart = "http://api.weatherapi.com/v1/forecast.json";

    @Value("${weather.api.key}")
    private String apiKey;


    public void fetchForecast(){
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(urlStart + "?key=" + apiKey + "&q=" + "chisinau" + "&days=2"))
                .GET()
                       .header("Accept", "application/json")
                .build();

        try {
            res = http.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(res.statusCode() + "\n" + res.body());
    }
}
