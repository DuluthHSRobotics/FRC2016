package org.usfirst.frc5293.framework.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.util.Logging

abstract class EmptySubsytem : Subsystem() {
    override fun initDefaultCommand() {
        defaultCommand = null
    }
}

abstract class DisablableSubsystem : EmptySubsytem(), Logging {

    open protected var isEnabled: Boolean = true

    fun enable() {
        isEnabled = true
        logger.info("Subsystem enabled")
    }

    fun disable() {
        isEnabled = false
        logger.info("Subsystem disabled")
    }
}