package hr.unizg.fer.karlo_sudec.Labos1.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.city.service.CityService;
import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService{


    private final RestTemplate restTemplate;
    @Value("${weatherApiKey}")
    private String weatherApiKey;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final WeatherRepository weatherRepository;
    private final CityService cityService;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate, WeatherRepository weatherRepository, CityService cityService) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
        this.cityService = cityService;
    }

    @Override
    public Weather getWeatherForCity(City city) {
        String WeatherApiUrl
                = "https://api.openweathermap.org/data/2.5/weather?q=" + city.getName() + "," +
                    city.getCountry() + "&appid=" + weatherApiKey;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(WeatherApiUrl, String.class);
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            Weather[] weathers = objectMapper.treeToValue(jsonNode.get("weather"), Weather[].class);
            saveWeathersIfNotExists(weathers);
            cityService.updateWeatherForCity(weathers[0], city);
            return weathers[0];
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public void saveWeathersIfNotExists(Weather[] weathers) {
        for (Weather weather : weathers) {
            saveWeatherIfNotExists(weather);
        }
    }

    @Override
    @Transactional
    public void saveWeatherIfNotExists(Weather weather) {
        if(weatherRepository.findById(weather.getId()).isEmpty()){
            weatherRepository.save(weather);
        }
    }
}
