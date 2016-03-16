package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.autonomous.AutonomousCommand

object AutonomousControls
        : LazyControlGroup()
        , Logging {

    val command by factoryByRequest {
        AutonomousCommand(Subsystems.drivetrain)
    }

    override val controls: List<*> by lazy {
        listOf(command)
    }
}