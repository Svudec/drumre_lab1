package hr.unizg.fer.karlo_sudec.Labos1.weather.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;

public interface WeatherService {

    Weather getWeatherForCity(City city);
}
