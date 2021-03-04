package com.lavreniuk.weatherforecast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utils {

    /**
     * Be careful!!! It could return list of nulls
     */
    public static List<String> fromObjectsToList(List<Object> objects) {
        return objects.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
    }

    public static String fromEpochToTimeString(long epochTime) {
        Date date = new Date(epochTime);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }
}
