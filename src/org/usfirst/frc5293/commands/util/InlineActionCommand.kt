package org.usfirst.frc5293.commands.util

import edu.wpi.first.wpilibj.command.Subsystem

class InlineActionCommand : ActionCommand {

    private val action: Runnable

    constructor(subsystem: Subsystem, action: Runnable) : super(subsystem) {
        this.action = action
    }

    constructor(subsystems: List<Subsystem>, action: Runnable) : super(subsystems) {
        this.action = action
    }

    override fun action() {
        action.run()
    }
}
