package com.snoroc.rest.api;

import com.snoroc.rest.data.CityForecastWeatherData;

import java.util.List;

public interface WeatherApi {

    List<CityForecastWeatherData> getForecastWeatherToCity(String city);
}
