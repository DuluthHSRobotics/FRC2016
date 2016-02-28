package org.usfirst.frc5293.input

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.SubsystemCommand

class CameraRingLight(val joystick: Joystick, val button: JoystickButton) {

    init {
        button.whenPressed(SubsystemCommand(Subsystems.cameraRingLight) {
            Subsystems.cameraRingLight.swap()
        })
    }
}
