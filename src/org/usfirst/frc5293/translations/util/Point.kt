package org.usfirst.frc5293.translations.util

data class Point(val x: Double, val y: Double) {
    operator fun unaryMinus() = Point(-x, -y)

    fun map(f: (Double) -> Double)= Point(f(x), f(y))
}