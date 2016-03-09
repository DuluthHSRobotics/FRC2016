package org.usfirst.frc5293.impl.systems.shooter.kicker

import edu.wpi.first.wpilibj.buttons.Button
import org.usfirst.frc5293.framework.commands.ScheduledCommandGroup
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.Prefs

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
                kicker.angle = Prefs.root.shooterKickerAngle.get()
                logger.debug("angle = ${kicker.angle} deg")
            }

            delay(seconds = Prefs.root.shooterKickerDelay.get())

            awaitIgnored {
                kicker.angle = 0.0
                logger.debug("angle = ${kicker.angle} deg")
            }
        }
    }
}