package org.weather.weatherapi.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.weather.weatherapi.dtos.ForecastDto;

import java.time.LocalDate;
import java.util.List;

@Service
public class ForecastMapper {
    public ForecastDto mapToForecastDto(JsonNode root){

        JsonNode forecastNode = root.path("forecast").path("forecastday");
        if (forecastNode.isMissingNode() || !forecastNode.isArray() || forecastNode.size() < 2) {
            throw new RuntimeException("Missing Data in Weather API JSON or is malformed");
        }

        ForecastDto forecastDto = new ForecastDto();
        forecastDto.setCity(root.path("location").path("name").asText());
        forecastDto.setDate(LocalDate.parse(root.path("forecast").path("forecastday").get(1).path("date").asText()));

        JsonNode tomorrow = forecastNode.get(1).path("day");
        forecastDto.setMinTempC(tomorrow.path("mintemp_c").asDouble());
        forecastDto.setMaxTempC(tomorrow.path("maxtemp_c").asDouble());
        forecastDto.setHumidity(tomorrow.path("avghumidity").asLong());
        forecastDto.setWindKph(tomorrow.path("maxwind_kph").asDouble());
        //forecastDto.setWindDir(tomorrow.path("wind_dir").asText()); Wind data is only specified per-hour basis.

        return forecastDto;
    }

    public void tabularizeData(List<ForecastDto> forecastDtoList){
        System.out.print("""
                +--------------+------------+----------+----------+----------+---------+
                |     City     |    Date    | MinTempC | MaxTempC | Humidity | WindKph |
                +--------------+------------+----------+----------+----------+---------+
                """
        );
        forecastDtoList.forEach(forecastDto->{
            System.out.printf(
                    "| %-12s | %-10s | %8.1f | %8.1f | %8d | %7.1f |\n",
                    forecastDto.getCity(),
                    forecastDto.getDate(),
                    forecastDto.getMinTempC(),
                    forecastDto.getMaxTempC(),
                    forecastDto.getHumidity(),
                    forecastDto.getWindKph()
            );
        });

        System.out.println("+--------------+------------+----------+----------+----------+---------+");
    }

}
