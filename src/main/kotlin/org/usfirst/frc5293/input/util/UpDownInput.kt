package org.usfirst.frc5293.input.util

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

abstract class UpDownInput(joystick: Joystick, upButtonNumber: Int, downButtonNumber: Int) {

    val upButton = JoystickButton(joystick, upButtonNumber)
    val downButton = JoystickButton(joystick, downButtonNumber)
}
