package com.snoroc.rest.api.impl;

import lombok.RequiredArgsConstructor;
import com.snoroc.rest.data.CityForecastWeatherData;
import com.snoroc.rest.api.WeatherForecastUrlProperties;
import com.snoroc.rest.api.response.WeatherForecast;
import com.snoroc.rest.api.WeatherApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherServiceApi implements WeatherApi {

    private final RestTemplate restTemplate;
    public final WeatherForecastUrlProperties weatherForecastUrlProperties;

    @Override
    public List<CityForecastWeatherData> getForecastWeatherToCity(String city) {
        ResponseEntity<WeatherForecast> weatherForecastResponse = restTemplate.getForEntity(weatherForecastUrlProperties.url() + "&q=" + city, WeatherForecast.class);
        if (200 == weatherForecastResponse.getStatusCodeValue()) {
            return weatherForecastResponse.getBody().getList().stream().map(
                    weatherForecast -> new CityForecastWeatherData(weatherForecastResponse.getBody().getCity().getName(),
                            weatherForecastResponse.getBody().getCity().getCountry(),
                            weatherForecast.getMain().getTemp(),
                            weatherForecast.getClouds().getAll(),
                            weatherForecast.getDt()))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
