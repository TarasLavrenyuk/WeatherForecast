package com.lavreniuk.weatherforecast;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class WeatherClient {

    private static final String ACCESS_KEY = "INSERT_YOUR_KEY_HERE_DUDE";
    private static final String CURRENT_WEATHER_URL = "http://api.weatherstack.com/current";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public WeatherData getCurrentWeather(final String location) throws URISyntaxException, IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(buildCurrentWeatherURI(ACCESS_KEY, location))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return parseResponse(response);
    }

    private URI buildCurrentWeatherURI(final String accessKey, final String location) throws URISyntaxException {
        return new URI(CURRENT_WEATHER_URL + "?access_key=" + ACCESS_KEY + "&query=" + location);
    }

    private static WeatherData parseResponse(HttpResponse<String> response) {
        JSONObject jsonObject = new JSONObject(response.body());
        String city = jsonObject.getJSONObject("location").getString("name");
        String country = jsonObject.getJSONObject("location").getString("country");
        String localtimeString = jsonObject.getJSONObject("location").getString("localtime");
        String time = localtimeString.substring(localtimeString.length() - 5);
        int temperature = jsonObject.getJSONObject("current").getInt("temperature");
        List<String> weatherDescription = Utils.fromObjectsToList(
                jsonObject
                        .getJSONObject("current")
                        .getJSONArray("weather_descriptions")
                        .toList()
        );

        return new WeatherData(
                city,
                country,
                time,
                temperature,
                weatherDescription
        );
    }
}
