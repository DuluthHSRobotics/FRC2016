package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.command.Subsystem

abstract class SubsystemCommand : ActionCommand {

    constructor(vararg subsystems: Subsystem) : super() {
        subsystems.forEach { requires(it) }
    }
}

fun SubsystemCommand(vararg subsystems: Subsystem, action: () -> Unit) =
    object : SubsystemCommand(*subsystems) {
        override fun action() {
            action()
        }
    }