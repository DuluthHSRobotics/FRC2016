package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.subsystems.SpeedControllerSubsystem
import org.usfirst.frc5293.framework.util.Logging

open class RawMotorSubsystemControl<TSubsystem>(
        private val input: () -> Double,
        private val subsystem: TSubsystem)
        : EmptyCommand(), Logging

        where TSubsystem : Subsystem,
              TSubsystem : SpeedControllerSubsystem {

    init {
        requires(subsystem)
    }

    override fun execute() {
        logger.debug("execute() { input() -> ${input()}")
        subsystem.power = input()
    }

    override fun end() {
        logger.debug("end()")
        subsystem.power = 0.0
    }

    override fun interrupted() {
        logger.debug("interrupted()")
        subsystem.power = 0.0
    }
}

class DeadzoneMotorSubsystemControl<TSubsystem>(
        private val input: () -> Double,
        private val subsystem: TSubsystem)
        : RawMotorSubsystemControl<TSubsystem>(input, subsystem),
          Logging

        where TSubsystem : Subsystem,
              TSubsystem : SpeedControllerSubsystem {

    override fun execute() {

        val deadzone = 0.15
        val value = input()

        if (Math.abs(value) > deadzone) {
            subsystem.power = value
//            logger.debug("execute() [power = $value]")
        } else {
            subsystem.stop()
//            logger.debug("execute() [power = 0.0]")
        }
    }
}

class HookedStreamControl(
        private val isEnabled: () -> Boolean,
        val child: Command)
        : EmptyCommand(), Logging {

    // TODO: Kotlin's class by delegation is not really working right now...

    override fun execute() {
//        logger.debug("execute() [isEnabled() -> ${isEnabled()}]")

        if (isEnabled()) {
            child.start()
        } else {
            child.cancel()
        }
    }
}