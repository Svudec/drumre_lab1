package hr.unizg.fer.karlo_sudec.Labos1.weather.service;

import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository extends MongoRepository<Weather, Long> {
}
