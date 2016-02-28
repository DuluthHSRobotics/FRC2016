package org.usfirst.frc5293.framework.translations.operations

import org.usfirst.frc5293.framework.translations.util.Point
import org.usfirst.frc5293.framework.util.math.limit
import org.usfirst.frc5293.framework.util.math.quadEase

fun applyInverting(state: Point) = -state

fun applyInputScaling(state: Point) = state.map { scaleInput(it) }

fun applyQuadScaling(state: Point) = state.map { quadEase(it) }

fun applyOutputLimit(state: Point) = state.map { it.limit(0.0, 1.0) }

/**
 * Scales the joystick input value to the servo value

 * @param value  the joystick input value [-1.0..1.0]
 * *
 * @return the server input value [0.0..1.0]
 */
fun scaleInput(value: Double): Double {
    var valueQ = value.limit(-1.0, 1.0)
    return (valueQ + 1.0) / 2.0
}
