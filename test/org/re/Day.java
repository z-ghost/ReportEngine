package org.re;

import java.util.List;

/**
 * Created by V.Zubchevskiy on 22.03.2016.
 */
public class Day {
    boolean sunny;
    int week;

    public Day(boolean sunny, int week) {
        this.sunny = sunny;
        this.week = week;
    }

    public boolean isSunny() {
        return sunny;
    }

    public boolean isRainy() {
        return !sunny;
    }

    public int getWeek() {
        return week;
    }
}
