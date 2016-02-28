package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

open class MotorSubsystemControl<TSubsystem>(
        private val input: () -> Double,
        private val subsystem: TSubsystem)
        : EmptyCommand()

        where TSubsystem : Subsystem,
              TSubsystem : MotorSubsystem {

    init {
        requires(subsystem)
    }

    override fun execute() {
        subsystem.power = input()
    }

    override fun end() {
        subsystem.power = 0.0
    }
}

class MotorDeadzoneSubsystemControl<TSubsystem>(
        private val input: () -> Double,
        private val subsystem: TSubsystem)
        : MotorSubsystemControl<TSubsystem>(input, subsystem)

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