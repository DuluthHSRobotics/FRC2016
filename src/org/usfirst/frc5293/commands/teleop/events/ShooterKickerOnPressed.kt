package org.usfirst.frc5293.commands.teleop.events

import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.ScheduledCommandGroup

class ShooterKickerOnPressed : ScheduledCommandGroup() {
    init {
        schedule {
            requires(Subsystems.shooterKicker)

            await { Subsystems.shooterKicker.angle = 70.0 }
            delay(seconds = 3.0)
            await { Subsystems.shooterKicker.angle = 0.0 }
        }
    }
}
