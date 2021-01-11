package com.snoroc.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "city_weather")
public class CityWeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "temperature_value")
    private double temperature;

    @Column(name = "clouds")
    private int clouds;

    @Column(name = "dt")
    private Instant dt;

    public CityWeatherEntity() {
    }

    public CityWeatherEntity(String cityName, String countryCode, double temperature, int clouds, Instant dt) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.temperature = temperature;
        this.clouds = clouds;
        this.dt = dt;
    }
}
