package org.usfirst.frc5293.impl.systems.lifter

import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

class SpeedControllerSubsystem(private val motor: SpeedController)
    : EmptySubsytem(), MotorSubsystem {

    override var power: Double
        get() = motor.get()
        set(value) = motor.set(value)

    override fun stop() {
        power = 0.0
    }
}
