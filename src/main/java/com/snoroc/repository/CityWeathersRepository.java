package com.snoroc.repository;

import com.snoroc.persistence.CityWeatherEntity;
import com.snoroc.rest.data.CityForecastWeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityWeathersRepository extends JpaRepository<CityWeatherEntity, Long> {

    @Query("select cw from CityWeatherEntity cw where cw.cityName = ?1")
    List<CityWeatherEntity> find(String city);
}
