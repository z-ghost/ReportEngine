package org.re;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly on 27.03.2016.
 */
public class WeatherBuilder {

    private List<Day> result = new ArrayList<>();
    int weekNumber = 1;


    public WeatherBuilder week(int sunnyCount) {
        assert  sunnyCount <=7;
        for(int i = 1; i <= 7; i++)
            result.add(new Day(i <= sunnyCount, weekNumber));
        weekNumber++;
        return this;
    }

    public List<Day> getList() {
        return result;

    }
}
