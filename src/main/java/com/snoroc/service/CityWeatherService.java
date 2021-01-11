package com.snoroc.service;

import com.snoroc.rest.data.CityData;
import com.snoroc.rest.data.CityForecastWeatherData;

import java.util.List;
import java.util.Optional;

public interface CityWeatherService {

    Optional<CityForecastWeatherData> find(CityData city);

    void save(List<CityForecastWeatherData> cityWeathers);
}
