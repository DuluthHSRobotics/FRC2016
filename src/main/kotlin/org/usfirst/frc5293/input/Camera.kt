package org.usfirst.frc5293.input

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.commands.teleop.events.CameraSetOriginOnPressed

class Camera(val joystick: Joystick) {
    private val originButton: JoystickButton

    init {

        this.originButton = JoystickButton(this.joystick, 1 /* Trigger */)
        this.originButton.whenActive(CameraSetOriginOnPressed())
    }
}
