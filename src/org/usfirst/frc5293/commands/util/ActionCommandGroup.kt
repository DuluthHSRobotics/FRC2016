package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.command.Subsystem

abstract class ActionCommandGroup : EmptyCommandGroup {

    protected var _isFinished = false

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

    override fun isFinished(): Boolean {
        return _isFinished
    }
}
