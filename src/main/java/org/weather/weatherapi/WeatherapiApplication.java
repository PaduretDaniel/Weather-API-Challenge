package org.weather.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.weather.weatherapi.services.ForecastService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WeatherapiApplication {

    static List<String> cities = new ArrayList<>(List.of("amsterdam", "chisinau", "kyiv","madrid"));

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WeatherapiApplication.class);
        System.setProperty("spring.main.web-application-type", "none");
        ConfigurableApplicationContext context = app.run(args);

        var forecaster = context.getBean(ForecastService.class);

        cities.forEach(forecaster::fetchForecast);
    }

}
