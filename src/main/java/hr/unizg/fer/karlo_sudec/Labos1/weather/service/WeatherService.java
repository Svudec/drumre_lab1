package hr.unizg.fer.karlo_sudec.Labos1.weather.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;

import java.util.List;

public interface WeatherService {

    Weather getWeatherForCity(City city);

    void saveWeathersIfNotExists(Weather[] weathers);

    void saveWeatherIfNotExists(Weather weather);
}
