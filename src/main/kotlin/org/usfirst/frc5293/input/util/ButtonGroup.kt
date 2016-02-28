package org.usfirst.frc5293.input.util

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.buttons.JoystickButton
import java.util.*

/**
 * A "psuedo-button" that wraps around a group of buttons.
 */
abstract class ButtonGroup : Button {
    val buttons: Collection<JoystickButton>

    constructor(vararg buttons: JoystickButton) {
        this.buttons = buttons.asList()
    }

    constructor(joystick: Joystick, vararg buttons: Int) {
        val joystickButtons = ArrayList<JoystickButton>()

        for (n in buttons) {
            joystickButtons.add(JoystickButton(joystick, n))
        }

        this.buttons = joystickButtons
    }
}
