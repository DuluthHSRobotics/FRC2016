package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.util.Initializable
import org.usfirst.frc5293.framework.util.Logging

abstract class ToggleButtonControl(val button: Button): Initializable, Logging {

    abstract val subsystems: List<Subsystem>

    abstract fun onToggle(isEnabled: Boolean): Unit

    private var didInit = false

    private var state = false

    override fun init() {
        if (didInit) return
        didInit = true

        button.whenPressed(object : SubsystemCommand(subsystems) {
            override fun action() {
                onToggle(state)
                state = !state
            }
        })
    }
}