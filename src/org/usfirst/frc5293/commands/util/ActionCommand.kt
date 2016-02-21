package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.command.Subsystem

abstract class ActionCommand : EmptyCommand {

    private var isFinished = false

    protected constructor() {
    }

    protected constructor(subsystem: Subsystem) {
        requires(subsystem)
    }

    protected constructor(subsystems: List<Subsystem>) {
        for (subsystem in subsystems) {
            requires(subsystem)
        }
    }

    protected abstract fun action()

    override fun execute() {
        action()
        isFinished = true
    }

    override fun isFinished(): Boolean {
        return isFinished
    }
}
