package com.snoroc.rest.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:weather_forecast_api.properties")
public class PropsConfig {
}
