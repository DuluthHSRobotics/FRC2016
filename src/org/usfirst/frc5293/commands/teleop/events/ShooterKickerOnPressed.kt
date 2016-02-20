package org.usfirst.frc5293.commands.teleop.events

import edu.wpi.first.wpilibj.command.WaitCommand
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.ActionCommand
import org.usfirst.frc5293.commands.util.ActionCommandGroup

class ShooterKickerOnPressed : ActionCommandGroup(Subsystems.shooterKicker) {

    init {
        addSequential(object : ActionCommand(Subsystems.shooterKicker) {
            override fun action() {
                Subsystems.shooterKicker.angle = 70.0
            }
        })

        addSequential(WaitCommand(3.0 /* seconds */))

        addSequential(object : ActionCommand(Subsystems.shooterKicker) {
            override fun action() {
                Subsystems.shooterKicker.angle = 0.0
            }
        })
    }
}
