package com.snoroc.rest.api.response;

import lombok.Data;

import java.time.Instant;

@Data
public class HourlyForecast {

    private Instant dt;
    private Temperature main;
    private Clouds clouds;
}
