package org.weather.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.weather.weatherapi.dtos.ForecastDto;
import org.weather.weatherapi.mappers.ForecastMapper;
import org.weather.weatherapi.services.ForecastService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WeatherapiApplication {
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(WeatherapiApplication.class);
        System.setProperty("spring.main.web-application-type", "none");
        ConfigurableApplicationContext context = app.run(args);

        var forecaster = context.getBean(ForecastService.class);
        var forecastMapper = context.getBean(ForecastMapper.class);

        List<String> cities = new ArrayList<>(List.of("amsterdam", "chisinau", "kyiv","madrid"));
        List<ForecastDto> results = new ArrayList<>();

        cities.forEach(c -> {
            try {
                results.add(forecaster.fetchForecast(c));
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        forecastMapper.tabularizeData(results);
    }
}
