package com.snoroc.rest.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastUrlProperties {

    @Value("${openweather.url}")
    private String baseUrl;

    @Value("${openweather.appid}")
    private String appId;

    @Value("${openweather.units}")
    private String units;

    public String url() {
            return baseUrl + "/" +  "?units=" + units + "&appid=" + appId;
        }
}
