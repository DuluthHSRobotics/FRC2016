package org.usfirst.frc5293.impl.systems.lift

import org.usfirst.frc5293.framework.subsystems.Direction
import org.usfirst.frc5293.framework.subsystems.DirectionalSubsystem
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

class LiftSubsystem(private val lifter: LiftDevice) : EmptySubsytem(), MotorSubsystem, DirectionalSubsystem {

    // TODO: Move this to using preferences
    val UP_POWER = 0.75

    val DOWN_POWER = -0.25

    override var power: Double
        get() = lifter.bottomMotor.get()
        set(value) = lifter.bottomMotor.set(value)

    override var direction: Direction
        get() =
            when {
                power > 0 -> Direction.UP
                power < 0 -> Direction.DOWN
                else -> Direction.NONE
            }

        set(value) {
            when (value) {
                Direction.UP -> power = UP_POWER
                Direction.DOWN -> power = DOWN_POWER
                Direction.NONE -> stop()
            }
        }

    override fun stop() {
        power = 0.0
    }
}
