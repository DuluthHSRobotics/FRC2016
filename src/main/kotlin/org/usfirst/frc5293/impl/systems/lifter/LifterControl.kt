package org.usfirst.frc5293.impl.systems.lifter

import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.controls.PushDownButtonControl
import org.usfirst.frc5293.framework.util.Logging

class LifterControl(
        button: JoystickButton,
        private val lifter: LifterSubsystem)
        : PushDownButtonControl(button),
          Logging {

    init {
        logger.debug("init")
    }

    override val subsystems = listOf(lifter)

    override fun onPressed() {
        lifter.power = 1.0
    }

    override fun onReleased() {
        lifter.stop()
    }
}