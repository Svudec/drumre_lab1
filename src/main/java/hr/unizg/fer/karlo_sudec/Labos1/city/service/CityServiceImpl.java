package hr.unizg.fer.karlo_sudec.Labos1.city.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
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
}
