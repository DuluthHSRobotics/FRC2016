package org.usfirst.frc5293.util;

public class Util {
    public static double easeInQuad(
            double time,
            double start,
            double change,
            double duration) {
        time /= duration;
        return change * Math.pow(time, 2) + start;
    }

    public static double clampMax(double value, double max) {
        if (value > max) return max;
        else return value;
    }
}
