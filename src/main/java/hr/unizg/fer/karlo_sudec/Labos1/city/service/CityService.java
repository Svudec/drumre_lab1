package hr.unizg.fer.karlo_sudec.Labos1.city.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;

public interface CityService {
    void saveCityIfNotExists(City city);
}
