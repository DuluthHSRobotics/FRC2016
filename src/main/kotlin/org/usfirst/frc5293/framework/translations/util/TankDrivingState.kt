package org.usfirst.frc5293.framework.translations.util

data class TankDrivingState(val left: Double, val right: Double) {
    fun map(f: (Double) -> Double) = TankDrivingState(f(left), f(right))
}
