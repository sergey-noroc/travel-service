package com.snoroc.service.impl;

import com.snoroc.rest.data.CityData;
import com.snoroc.rest.data.CityForecastWeatherData;
import com.snoroc.persistence.CityWeatherEntity;
import com.snoroc.repository.CityWeathersRepository;
import com.snoroc.service.CityWeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultCityWeatherService implements CityWeatherService {

    private final CityWeathersRepository cityWeathersRepository;

    @Override
    public Optional<CityForecastWeatherData> find(CityData cityData) {

        List<CityWeatherEntity> cityWeatherEntities = cityWeathersRepository.find(cityData.getCity());
        List<CityForecastWeatherData> cityForecastWeatherData = cityWeatherEntities.stream().map(
                cityWeatherEntity -> new CityForecastWeatherData(cityWeatherEntity.getCityName(),
                        cityWeatherEntity.getCountryCode(),
                        cityWeatherEntity.getTemperature(),
                        cityWeatherEntity.getClouds(),
                        cityWeatherEntity.getDt())
        ).collect(Collectors.toList());

        if (cityForecastWeatherData.isEmpty()) {
            return Optional.empty();
        }

        return cityForecastWeatherData.stream().findAny();

    }

    @Override
    public void save(List<CityForecastWeatherData> cityWeathers) {
        cityWeathersRepository.saveAll(cityWeathers.stream().map(cityWeatherData ->
                new CityWeatherEntity(
                        cityWeatherData.getCityName(),
                        cityWeatherData.getCountryCode(),
                        cityWeatherData.getTemperature(),
                        cityWeatherData.getClouds(),
                        cityWeatherData.getDate()))
                .collect(toList()));
    }
}
