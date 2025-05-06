package com.weather.weatherApi.controller;

import com.weather.weatherApi.models.WeatherData;
import com.weather.weatherApi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherData getWeather(@PathVariable String city){
        WeatherData weatherData = weatherService.getWeather(city);
        return weatherData;
    }

}
