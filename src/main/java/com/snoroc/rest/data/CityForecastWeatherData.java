package com.snoroc.rest.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class CityForecastWeatherData {

    private String cityName;
    private String countryCode;
    private double temperature;
    private int clouds;
    private Instant date;
}
