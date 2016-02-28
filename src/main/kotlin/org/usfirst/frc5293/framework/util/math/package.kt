package org.usfirst.frc5293.framework.util.math

/**
 * Applies quadratic function with no deadzone intended for input of [-1.0..1.0]
 *
 * @param x  the input in the range of [-1.0..1.0]
 *
 * @return the output of the function
 */
fun quadEase(x: Double): Double {
    return quadEaseWithDeadzone(x, 0.0)
}

/**
 * Applies quadratic function with deadzone intended for input of [-1.0..1.0]
 *
 * @param value  the input in the range of [-1.0..1.0]
 * @param deadzone  the range of the deadzone
 *
 * @return the output of the function
 */
fun quadEaseWithDeadzone(value: Double, deadzone: Double): Double {
    return powerEaseWithDeadzone(value, 2, deadzone)
}

/**
 * Applies quadratic function with deadzone intended for input of [-1.0..1.0]
 *
 * @param value  the input in the range of [-1.0..1.0]
 * @param power  the power to use in the function
 * @param deadzone  the range of the deadzone
 *
 * @return the output of the function
 */
fun powerEaseWithDeadzone(value: Double, power: Int, deadzone: Double): Double {
    @Suppress("NAME_SHADOWING")
    var deadzone = deadzone

    // Half the deadzone since there is two sides to the equation
    deadzone /= 2.0

    if (value > -deadzone && value < deadzone) {
        return 0.0
    } else if (value < -deadzone) {
        return -Math.abs(Math.pow(value + deadzone, power.toDouble()))
    } else {
        // value > deadzone
        return Math.abs(Math.pow(value - deadzone, power.toDouble()))
    }
}

/**
 * Limit a value to a maximum value.
 *
 * @param max the maximum value to allow
 * @return the limited value
 */
fun Double.limitMax(max: Double): Double {
    if (this > max)
        return max
    else
        return this
}

/**
 * Limits a value to be between a minimum and a maximum
 *
 * @param min the minimum value to allow
 * @param max the maximum value to allow
 *
 * @return the limited value
 */
fun Double.limit(min: Double, max: Double): Double {
    if (this < min)
        return min
    else if (this > max)
        return max
    else
        return this
}
