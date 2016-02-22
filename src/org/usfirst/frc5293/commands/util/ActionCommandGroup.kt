package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.command.Subsystem

abstract class ActionCommandGroup : EmptyCommandGroup {

    private var _isFinished = false

    protected constructor(vararg subsystems: Subsystem) {
        subsystems.forEach { requires(it) }
    }

    override fun isFinished(): Boolean {
        return _isFinished
    }

    protected fun done() {
        _isFinished = true
    }
}
