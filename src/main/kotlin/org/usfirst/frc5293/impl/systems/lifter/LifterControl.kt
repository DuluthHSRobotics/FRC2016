package org.usfirst.frc5293.impl.systems.lifter

import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.controls.PushDownButtonControl

class LifterControl(
        button: JoystickButton,
        private val lifter: LifterSubsystem)
        : PushDownButtonControl(button) {

    override val subsystems: List<Subsystem>
        get() = listOf(lifter)

    override fun onPressed() {
        lifter.power = 1.0
    }

    override fun onReleased() {
        lifter.stop()
    }
}