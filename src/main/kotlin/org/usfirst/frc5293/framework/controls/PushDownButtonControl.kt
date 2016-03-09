package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.util.Initializable

abstract class PushDownButtonControl(val button: JoystickButton): Initializable {

    abstract val subsystems: List<Subsystem>

    abstract fun onPressed(): Unit

    abstract fun onReleased() : Unit

    private var didInit = false

    override fun init() {
        if (didInit) return
        didInit = true

        button.whileHeld(object : SubsystemCommand(*subsystems.toTypedArray()) {
            override fun action() {
                onPressed()
            }
        })

        button.whenReleased(object : SubsystemCommand(*subsystems.toTypedArray()) {
            override fun action() {
                onReleased()
            }
        })
    }
}