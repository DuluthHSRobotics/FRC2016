package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem
import org.usfirst.frc5293.framework.util.Logging

open class RawMotorSubsystemControl<TSubsystem>(
        private val input: () -> Double,
        private val subsystem: TSubsystem)
        : EmptyCommand(), Logging

        where TSubsystem : Subsystem,
              TSubsystem : MotorSubsystem {

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
}

class DeadzoneMotorSubsystemControl<TSubsystem>(
        private val input: () -> Double,
        private val subsystem: TSubsystem)
        : RawMotorSubsystemControl<TSubsystem>(input, subsystem)

        where TSubsystem : Subsystem,
              TSubsystem : MotorSubsystem {

    override fun execute() {
        val deadzone = 0.15
        val value = input()

        if (Math.abs(value) > deadzone) {
            subsystem.power = value
        } else {
            subsystem.stop()
        }
    }
}

class HookedControl(private val isEnabled: () -> Boolean, val child: Command) : EmptyCommand() {

    // TODO: Kotlin's class by delegation is not really working right now...

    override fun interrupted() {
        child.interrupted()
    }

    override fun end() {
        child.end()
    }

    override fun execute() {
        if (!isEnabled()) return
        child.execute()
    }

    override fun isFinished(): Boolean {
        return child.isFinished()
    }

    override fun initialize() {
        child.initialize()
    }
}