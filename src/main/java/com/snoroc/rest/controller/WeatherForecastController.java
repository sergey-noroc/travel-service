package com.snoroc.rest.controller;

import com.snoroc.rest.data.CityData;
import com.snoroc.rest.data.CityForecastWeatherData;
import com.snoroc.rest.api.WeatherApi;
import com.snoroc.service.CityWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class WeatherForecastController {

    private final CityWeatherService cityWeatherService;
    private final WeatherApi weatherApi;

    @PostMapping("/search-forecast-weather")
    ResponseEntity<?> searchForecastWeather(@RequestBody CityData cityData, HttpServletResponse response) throws IOException {

        Optional<CityForecastWeatherData> cityForecastWeatherData = cityWeatherService.find(cityData);

        if (cityForecastWeatherData.isEmpty()) {
            List<CityForecastWeatherData> cityWeather = weatherApi.getForecastWeatherToCity(cityData.getCity());
            cityWeatherService.save(cityWeather);
        }

        return new ResponseEntity<>(cityForecastWeatherData, HttpStatus.OK);
    }

    @GetMapping("/get-forecast-weather")
    ResponseEntity<?> getForecastWeather(HttpServletResponse response) throws IOException {

        //TODO
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
