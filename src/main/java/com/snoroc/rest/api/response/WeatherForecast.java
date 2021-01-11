package com.snoroc.rest.api.response;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class WeatherForecast {

    private List<HourlyForecast> list;
    private City city;

    public City getCity() {
        return city;
    }
}
