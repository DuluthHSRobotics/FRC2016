package org.usfirst.frc5293.input

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.commands.teleop.events.ShooterKickerTryStart

class ShooterKicker(val joystick: Joystick, val kickButton: JoystickButton) {

    init {
        kickButton.whenPressed(ShooterKickerTryStart())
    }
}
