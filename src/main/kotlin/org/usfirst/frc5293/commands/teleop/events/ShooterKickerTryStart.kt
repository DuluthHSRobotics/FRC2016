package org.usfirst.frc5293.commands.teleop.events

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import org.usfirst.frc5293.commands.util.ActionCommand

class ShooterKickerTryStart : ActionCommand() {

    companion object {
        private var current: Command? = null
    }

    override fun action() {
        if (current != null) {
            return
        }

        current = ShooterKickerOnPressed()
        Scheduler.getInstance().add(current)
    }
}