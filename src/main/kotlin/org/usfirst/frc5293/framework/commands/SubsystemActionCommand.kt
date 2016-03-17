package org.usfirst.frc5293.framework.commands

import edu.wpi.first.wpilibj.command.Subsystem

abstract class SubsystemActionCommand : ActionCommand {

    constructor(subsystems: List<Subsystem>) : super() {
        subsystems.forEach { requires(it) }
    }

    constructor(vararg subsystems: Subsystem) : this(subsystems.asList()) {
    }
}

fun SubsystemActionCommand(vararg subsystems: Subsystem, action: (SubsystemActionCommand) -> Unit) =
    object : SubsystemActionCommand(*subsystems) {
        override fun action() {
            action(this)
        }
    }