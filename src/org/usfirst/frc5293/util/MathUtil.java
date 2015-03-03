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
     * Applies quadratic function with no deadzone intended for input of [-1.0..1.0]
     * @param x  the input in the range of [-1.0..1.0]
     * @return the output of the function
     */
    public static double quad(double x) {
        return quadDeadzone(x, 0);
    }

    /**
     * Applies quadratic function with deadzone intended for input of [-1.0..1.0]
     * @param x  the input in the range of [-1.0..1.0]
     * @param deadzone  the range of the deadzone
     * @return the output of the function
     */
    public static double quadDeadzone(double x, double deadzone) {
        // Half the deadzone since there is two sides to the equation
        deadzone /= 2;

        if (x > -deadzone && x < deadzone) {
            return 0;
        } else if (x < -deadzone) {
            return -Math.pow(x + deadzone, 2);
        } else { // x > deadzone
            return Math.pow(x - deadzone, 2);
        }
    }

    /**
     * Limit a value to a maximum value.
     *
     * @param value the value to limit
     * @param max the maximum value to allow
     * @return the limited value
     */
    public static double limitMax(double value, double max) {
        if (value > max) return max;
        else return value;
    }

    /**
     * Limits a value to be between a minimum and a maximum
     * @param value the value to limit
     * @param min the minimum value to allow
     * @param max the maximum value to allow
     * @return the limited value
     */
    public static double limit(double value, double min, double max) {
        if (value < min) return min;
        else if (value > max) return max;
        else return value;
    }
}
