package com.weather.weatherApi.service;

import com.weather.weatherApi.models.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherData getWeather(String city){
        WeatherData cachedData = cacheService.getFromCache(city, WeatherData.class);
        if(cachedData != null){
            return cachedData;
        }
        WeatherData response = getWeatherFromApi(city);
        cacheService.saveToCache(city, response, 60);
        return response;
    }

    private WeatherData getWeatherFromApi(String city) {
        String url = String.format("%s/%s?unitGroup=us&elements=datetime,tempmax,tempmin,temp,feelslikemax,feelslikemin,feelslike,humidity&include=days&key=%s"
                , apiUrl, city, apiKey);
        return restTemplate.getForObject(url, WeatherData.class);
    }

}
