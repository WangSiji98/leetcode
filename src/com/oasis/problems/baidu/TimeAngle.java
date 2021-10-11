package com.oasis.problems.baidu;

/**
 * 任意时刻时针与分针的夹角
 */
public class TimeAngle {

    public double getTimeAngle(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return Math.abs(360.0 * minute / 60.0 - 30.0 * ((int) hour % 12) - 0.5 * minute) % 360;
    }

}
