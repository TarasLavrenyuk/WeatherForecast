package com.lavreniuk.weatherforecast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherData {

    private String city;
    private String country;
    private String time;
    private int temperature;
    private List<String> weatherDescription;

    public WeatherData(String city, String country, String time, int temperature, List<String> weatherDescription) {
        this.city = city;
        this.country = country;
        this.time = time;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public int getTemperature() {
        return temperature;
    }

    public List<String> getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return "It's " + time + " in " + city + ", " + country + ". The temperature is " + temperature + " celsius degrees. " +
                "The weather overall is " + String.join(",", weatherDescription).toLowerCase() + ".";
    }
}
