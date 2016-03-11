package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.Logging

object AutonomousControls : LazyControlGroup(), Logging {

    val command by lazyByRequest {
        EmptyCommand()
    }

    override val controls: List<*> by lazy {
        listOf(command)
    }
}