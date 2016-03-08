package org.usfirst.frc5293.impl.systems.shooter.kicker

import edu.wpi.first.wpilibj.buttons.Button
import org.usfirst.frc5293.framework.commands.ScheduledCommandGroup
import org.usfirst.frc5293.framework.util.Logging

class ShooterKickerControl(val kickButton: Button, subsystem: ShooterKickerSubsystem) {
    init {
        kickButton.whenPressed(ShooterKickerOnPressed(subsystem))
    }
}

class ShooterKickerOnPressed(val kicker: ShooterKickerSubsystem) : ScheduledCommandGroup(), Logging {

    init {
        schedule {
            requires(kicker)

            awaitIgnored {
                kicker.angle = 70.0
                logger.debug("angle = 70 deg")
            }

            delay(seconds = 3.0)

            awaitIgnored {
                kicker.angle = 0.0
                logger.debug("angle = 0 deg")
            }
        }
    }
}