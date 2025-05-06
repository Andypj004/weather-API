package com.weather.weatherApi.models;

import lombok.Data;
import java.util.List;

@Data
public class WeatherData {
    private int queryCost;
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private double tzoffset;
    private List<Day> days;

    @Data
    public static class Day {
        private String datetime;
        private double tempmax;
        private double tempmin;
        private double temp;
        private double feelslikemax;
        private double feelslikemin;
        private double feelslike;
        private double humidity;
    }
}
