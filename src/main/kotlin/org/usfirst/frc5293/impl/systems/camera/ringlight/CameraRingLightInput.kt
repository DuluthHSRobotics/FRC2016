package org.usfirst.frc5293.impl.systems.camera.ringlight

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.framework.commands.SubsystemCommand

class CameraRingLightInput(
        val joystick: Joystick,
        val button: JoystickButton,
        val ringLight: CameraRingLightSubsystem) {

    init {
        button.whenPressed(SubsystemCommand(ringLight) {
            ringLight.swap()
        })
    }
}
