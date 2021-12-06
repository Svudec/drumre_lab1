package hr.unizg.fer.karlo_sudec.Labos1.weather.controller;

import hr.unizg.fer.karlo_sudec.Labos1.city.entity.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getWeather(@ModelAttribute City city, BindingResult errors, Model model){
        return "layout";
    }
}
