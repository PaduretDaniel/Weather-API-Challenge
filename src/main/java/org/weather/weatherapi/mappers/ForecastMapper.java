package org.weather.weatherapi.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import org.weather.weatherapi.dtos.ForecastDto;

import java.time.LocalDate;
import java.util.List;

public class ForecastMapper {

    public static ForecastDto mapToForecastDto(JsonNode root){
        ForecastDto forecastDto = new ForecastDto();
        forecastDto.setCity(root.path("location").path("name").asText());
        forecastDto.setDate(LocalDate.parse(root.path("forecast").path("forecastday").get(1).path("date").asText()));
        JsonNode tomorrow = root.path("forecast").path("forecastday").get(1).path("day");
        forecastDto.setMinTempC(tomorrow.path("mintemp_c").asDouble());
        forecastDto.setMaxTempC(tomorrow.path("maxtemp_c").asDouble());
        forecastDto.setHumidity(tomorrow.path("avghumidity").asLong());
        forecastDto.setWindKph(tomorrow.path("maxwind_kph").asDouble());
        //forecastDto.setWindDir(tomorrow.path("wind_dir").asText()); Wind data is only specified per-hour basis.

        return forecastDto;
    }

    public static void tabularizeData(List<ForecastDto> forecastDtoList){
        //I'll finish you tomorrow
    }

}
