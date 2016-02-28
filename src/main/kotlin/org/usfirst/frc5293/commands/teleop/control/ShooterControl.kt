package org.usfirst.frc5293.commands.teleop.control

import org.usfirst.frc5293.Inputs
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.EmptyCommand

class ShooterControl : EmptyCommand() {

    init {
        requires(Subsystems.shooter)
    }

    override fun execute() {
        val deadzone = 0.10
        val raw = Inputs.shooter.joystick.y

        if (Math.abs(raw) > deadzone) {
            Subsystems.shooter.power = raw
        } else {
            Subsystems.shooter.stop()
        }
    }

    override fun end() {
        Subsystems.shooter.stop()
    }
}

class Lift : EmptyCommand() {

    private val lift = Subsystems.lift

    init {
        requires(lift)
    }

    override fun execute() {
        val deadzone = 0.20
        val raw = Inputs.lifter.joystick.y

        if (Math.abs(raw) > deadzone) {
            lift.power = raw
        } else {
            lift.power = 0.0
        }
    }

    override fun end() {
        lift.power = 0.0
    }
}
