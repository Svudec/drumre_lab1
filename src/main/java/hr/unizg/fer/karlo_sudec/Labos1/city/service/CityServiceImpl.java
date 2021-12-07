package hr.unizg.fer.karlo_sudec.Labos1.city.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;
import hr.unizg.fer.karlo_sudec.Labos1.weather.service.WeatherRepository;
import hr.unizg.fer.karlo_sudec.Labos1.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    @Override
    @Transactional
    public void saveCityIfNotExists(City city) {
        city.overrideId();
        if(cityRepository.findById(city.getId()).isEmpty()){
            cityRepository.save(city);
        }
    }

    @Override
    @Transactional
    public void updateWeatherForCity(Weather weather, City city) {
        saveCityIfNotExists(city);
        city.overrideId();

        city.setWeather(weather);
        cityRepository.save(city);
    }
}
