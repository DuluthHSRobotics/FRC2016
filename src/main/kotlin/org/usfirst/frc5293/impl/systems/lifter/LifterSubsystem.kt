package org.usfirst.frc5293.impl.systems.lifter

import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

class LifterSubsystem(private val lifter: LifterDevice)
        : EmptySubsytem(),
          MotorSubsystem {

    override var power: Double
        get() = lifter.bottomMotor.get()
        set(value) = lifter.bottomMotor.set(value)

    override fun stop() {
        power = 0.0
    }
}
