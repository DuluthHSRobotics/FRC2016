package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.commands.teleop.control.Lift
import org.usfirst.frc5293.subsystems.util.MotorSubsystem

class Subsystem(private val lifter: Device) : Subsystem(), MotorSubsystem, LiftSubsystem {

    // TODO: Move this to using preferences
    val UP_POWER = 0.75

    val DOWN_POWER = -0.25

    override fun initDefaultCommand() {
        defaultCommand = Lift()
    }

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
