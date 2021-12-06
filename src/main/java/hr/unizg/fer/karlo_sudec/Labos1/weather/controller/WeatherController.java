package hr.unizg.fer.karlo_sudec.Labos1.weather.controller;

import com.neovisionaries.i18n.CountryCode;
import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import hr.unizg.fer.karlo_sudec.Labos1.weather.entity.Weather;
import hr.unizg.fer.karlo_sudec.Labos1.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getWeather(@ModelAttribute City city, BindingResult errors, Model model, @AuthenticationPrincipal OAuth2User user){
        Weather weather = weatherService.getWeatherForCity(city);

        model.addAttribute("name", user.getAttribute("name"));
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);

        model.addAttribute("contentName", "weatherSongs");
        return "layout";
    }
}
