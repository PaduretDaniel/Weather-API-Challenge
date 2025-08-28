package org.weather.weatherapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDto {
    private String city;
    private LocalDate date;
    private double minTempC;
    private double maxTempC;
    private long humidity;
    private double windKph;
    //private String windDir; Data is only specified per-hour basis.
}
