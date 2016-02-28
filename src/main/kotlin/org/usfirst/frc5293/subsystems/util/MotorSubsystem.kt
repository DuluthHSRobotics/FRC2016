package org.usfirst.frc5293.subsystems.util

interface MotorSubsystem {
    var power: Double

    fun stop() {
        power = 0.0
    }
}