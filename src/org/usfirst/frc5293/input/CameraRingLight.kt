package org.usfirst.frc5293.input

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.ActionCommand

class CameraRingLight(val joystick: Joystick, val button: JoystickButton) {

    init {
        button.whenPressed(object : ActionCommand(Subsystems.cameraRingLight) {
            override fun action() {
                Subsystems.cameraRingLight.swap()
            }
        })
    }
}
