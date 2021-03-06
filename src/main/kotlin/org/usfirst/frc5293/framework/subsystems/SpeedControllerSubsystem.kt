package org.usfirst.frc5293.framework.subsystems

interface SpeedControllerSubsystem : VariableSubsystem {
    var power: Double

    override var value: Double
        get() = power
        set(value) {
            power = value
        }

    fun stop() {
        power = 0.0
    }
}