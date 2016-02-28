package org.usfirst.frc5293.framework.input

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

/**
 * A "psuedo-button" that wraps around a group of buttons. This "pseudo-button" is considered
 * pressed **only** when **all** of the underlying buttons are pressed.
 */
class AndButtonGroup : ButtonGroup {

    constructor(vararg buttons: JoystickButton) : super(*buttons)

    constructor(joystick: Joystick, vararg buttons: Int) : super(joystick, *buttons)

    override fun get(): Boolean = buttons.all { it.get() }
}
