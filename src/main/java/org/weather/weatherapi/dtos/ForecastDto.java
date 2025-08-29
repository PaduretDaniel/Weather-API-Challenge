package org.weather.weatherapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ForecastDto {
    private String city;
    private LocalDate date;
    private double minTempC;
    private double maxTempC;
    private long humidity;
    private double windKph;
    //private String windDir; wind direction data is only specified per-hour basis.
}
