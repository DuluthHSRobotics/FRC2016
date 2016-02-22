package org.usfirst.frc5293.commands.teleop.control

import org.usfirst.frc5293.Input
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.EmptyCommand

class ShooterKickerControl : EmptyCommand() {

    init {
        requires(Subsystems.shooterKicker)
    }

    override fun execute() {
        val deadzone = 0.10
        val raw = Input.shooterKicker.joystick.y

        if (Math.abs(raw) > deadzone) {
            Subsystems.shooterKicker.value = raw
        }
    }
}
