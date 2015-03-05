package org.usfirst.frc5293.util;

public class MathUtil {

    /**
     * Applies quadratic function with no deadzone intended for input of [-1.0..1.0]
     * @param x  the input in the range of [-1.0..1.0]
     * @return the output of the function
     */
    public static double quadEase(double x) {
        return quadEaseWithDeadzone(x, 0);
    }

    /**
     * Applies quadratic function with deadzone intended for input of [-1.0..1.0]
     * @param value  the input in the range of [-1.0..1.0]
     * @param deadzone  the range of the deadzone
     * @return the output of the function
     */
    public static double quadEaseWithDeadzone(double value, double deadzone) {
        return powerEaseWithDeadzone(value, 2, deadzone);
    }

    /**
     * Applies quadratic function with deadzone intended for input of [-1.0..1.0]
     * @param value  the input in the range of [-1.0..1.0]
     * @param power  the power to use in the function
     * @param deadzone  the range of the deadzone
     * @return the output of the function
     */
    public static double powerEaseWithDeadzone(double value, int power, double deadzone) {
        // Half the deadzone since there is two sides to the equation
        deadzone /= 2;

        if (value > -deadzone && value < deadzone) {
            return 0;
        } else if (value < -deadzone) {
            return - Math.abs(Math.pow(value + deadzone, power));
        } else { // value > deadzone
            return Math.abs(Math.pow(value - deadzone, power));
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
