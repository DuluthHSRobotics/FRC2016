package org.usfirst.frc5293.util;

public class MathUtil {
    /**
     * A quadratic ease-in function.
     * @param time      the current time
     * @param start     the initial starting value
     * @param change    the change in value
     * @param duration  the total duration of the ease-in in terms of {@code time}
     * @return the resulting value of the iteration at {@code time}
     */
    public static double easeInQuad(
            double time,
            double start,
            double change,
            double duration) {
        time /= duration;
        return change * Math.pow(time, 2) + start;
    }

    /**
     * Clamps a value to a maximum value.
     * 
     * If the value is greater than the max, the max is returned.
     * Otherwise the value is returned.
     *
     * @param value the value to clamp
     * @param max the maximum value to allow
     * @return the clamped value
     */
    public static double clampMax(double value, double max) {
        if (value > max) return max;
        else return value;
    }
}
