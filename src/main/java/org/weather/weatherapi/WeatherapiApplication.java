package org.weather.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WeatherapiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WeatherapiApplication.class);
        System.setProperty("spring.main.web-application-type", "none");
        app.run(args);
    }

}
