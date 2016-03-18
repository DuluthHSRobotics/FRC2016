package org.usfirst.frc5293.framework.subsystems

import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.SpeedControllerSubsystem

class MotorSubsystem(private val motor: SpeedController)
    : EmptySubsytem(), SpeedControllerSubsystem {

    override var power: Double
        get() = motor.get()
        set(value) = motor.set(value)

    override fun stop() {
        power = 0.0
    }

    val isMoving = Math.abs(power) > 0.0
}
