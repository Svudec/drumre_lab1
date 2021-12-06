package hr.unizg.fer.karlo_sudec.Labos1.city.service;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, Long> {
}
