package org.usfirst.frc5293.framework.translations.util

data class ArcadeDrivingState(val power: Double, val rotation: Double) {
    fun map(f: (Double) -> Double) = TankDrivingState(f(power), f(rotation))
}
