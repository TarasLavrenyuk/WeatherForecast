package com.lavreniuk.weatherforecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class Main {

    private static final String TERMINATE_COMMAND = "exit";

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        WeatherClient weatherClient = new WeatherClient();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
            System.out.println("Please type city name.\nType 'exit' to log out.\n");
            input = reader.readLine().trim().toLowerCase();
            if (input.isBlank()) {
                continue;
            }
            if (input.equals(TERMINATE_COMMAND)) {
                break;
            }
            if (input.contains(",")) {
                System.out.println("Please specify only one city.");
                continue;
            }
            System.out.println(weatherClient.getCurrentWeather(input));
        }
    }
}
