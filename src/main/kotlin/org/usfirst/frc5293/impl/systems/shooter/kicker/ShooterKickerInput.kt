package org.usfirst.frc5293.impl.systems.shooter.kicker

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

class ShooterKickerInput(
        val joystick: Joystick,
        val kickButton: JoystickButton,
        val subsystem: ShooterKickerSubsystem) {

    init {
        kickButton.whenPressed(ShooterKickerOnPressed(subsystem))
    }
}
