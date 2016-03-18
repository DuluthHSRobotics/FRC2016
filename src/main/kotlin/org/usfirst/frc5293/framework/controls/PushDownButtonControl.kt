package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemActionCommand
import org.usfirst.frc5293.framework.util.Initializable
import org.usfirst.frc5293.framework.util.Logging

abstract class PushDownButtonControl(val button: Button): Initializable, Logging {

    abstract val subsystems: List<Subsystem>

    abstract fun onPressed(): Unit

    abstract fun onReleased() : Unit

    private var didInit = false

    override fun init() {
        if (didInit) return
        didInit = true

        button.whileHeld(object : SubsystemActionCommand(*subsystems.toTypedArray()) {
            override fun action() {
                logger.debug("onPressed()")
                onPressed()
            }
        })

        button.whenReleased(object : SubsystemActionCommand(*subsystems.toTypedArray()) {
            override fun action() {
                logger.debug("onReleased()")
                onReleased()
            }
        })
    }
}

abstract class EnableDisableButtonControl(val button: Button): Initializable, Logging {

    abstract val subsystems: List<Subsystem>

    abstract fun onPressed(): Unit

    abstract fun onReleased() : Unit

    private var didInit = false

    override fun init() {
        if (didInit) return
        didInit = true

        button.whileHeld(object : SubsystemActionCommand(*subsystems.toTypedArray()) {
            override fun action() {
                logger.debug("onPressed()")
                onPressed()
            }
        })

        button.whenReleased(object : SubsystemActionCommand(*subsystems.toTypedArray()) {
            override fun action() {
                logger.debug("onReleased()")
                onReleased()
            }
        })
    }
}

fun EnableDisableButtonControl(
        button: Button,
        vararg subsystems: Subsystem,
        onPressed: () -> Unit,
        onReleased: () -> Unit) {

    object : EnableDisableButtonControl(button) {
        override val subsystems = subsystems.asList()

        override fun onPressed() = onPressed()

        override fun onReleased() = onReleased()
    }
}