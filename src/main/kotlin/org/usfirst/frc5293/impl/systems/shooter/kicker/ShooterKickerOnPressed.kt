package org.usfirst.frc5293.impl.systems.shooter.kicker

import org.usfirst.frc5293.framework.commands.ScheduledCommandGroup

class ShooterKickerOnPressed(val kicker: ShooterKickerSubsystem) : ScheduledCommandGroup() {
    init {
        schedule {
            requires(kicker)

            await { kicker.angle = 70.0 }
            delay(seconds = 3.0)
            await { kicker.angle = 0.0 }
        }
    }
}
