package org.usfirst.frc5293.impl.autonomous

import org.usfirst.frc5293.framework.commands.ScheduledCommandGroup
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.Prefs
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainSubsystem

class ShooterKickerOnPressed(val drive: DrivetrainSubsystem) : ScheduledCommandGroup(), Logging {

    init {
        schedule {
            requires(drive)

            awaitIgnored {
                val power = Prefs.autonomous.drivePower.get()
                drive.driveTank(power, power)
            }

            delay(seconds = Prefs.root.shooterKickerDelay.get())

            awaitIgnored {
                drive.stop()
            }
        }
    }
}