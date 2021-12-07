package hr.unizg.fer.karlo_sudec.Labos1.city.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;

public interface CityService {
    void saveCityIfNotExists(City city);

    void updateWeatherForCity(Weather weather, City city);
}
