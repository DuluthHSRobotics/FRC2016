package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand

abstract class PushDownButtonControl(val button: JoystickButton) {

    abstract val subsystems: List<Subsystem>

    abstract fun onPressed(): Unit

    abstract fun onReleased() : Unit

    init {
        button.whileHeld(object : SubsystemCommand(*subsystems.toTypedArray()) {
            override fun action() {
                onPressed()
            }

            override fun end() {
                onReleased()
            }
        })
    }
}