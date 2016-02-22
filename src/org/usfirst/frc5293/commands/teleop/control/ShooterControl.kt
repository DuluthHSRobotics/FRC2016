package org.usfirst.frc5293.commands.teleop.control

import org.usfirst.frc5293.Input
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.EmptyCommand

class ShooterControl : EmptyCommand() {

    init {
        requires(Subsystems.shooter)
    }

    override fun execute() {
        val deadzone = 0.10
        val raw = Input.shooter.joystick.y

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
