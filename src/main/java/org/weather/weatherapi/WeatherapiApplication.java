package org.weather.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.weather.weatherapi.services.ForecastService;

@SpringBootApplication
public class WeatherapiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WeatherapiApplication.class);
        System.setProperty("spring.main.web-application-type", "none");
        ConfigurableApplicationContext context = app.run(args);

        var forecaster = context.getBean(ForecastService.class);

        forecaster.fetchForecast();
    }

}
