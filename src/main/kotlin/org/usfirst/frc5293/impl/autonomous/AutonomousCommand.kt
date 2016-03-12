package org.usfirst.frc5293.impl.autonomous

import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.commands.ScheduledCommandGroup
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.Prefs
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainSubsystem

class AutonomousCommand(val drive: DrivetrainSubsystem) : EmptyCommand(), Logging {

    val time by lazy {
        val x = Prefs.autonomous.driveTime.get()
        logger.debug("Running autonomous for $x seconds...")
        x
    }

    init {
        requires(drive)
    }

    override fun execute() {
        if (timeSinceInitialized() > time) {
            done()
            logger.debug("Finished running autonomous")
            return
        }

        val power = Prefs.autonomous.drivePower.get()
        drive.driveTank(power, power)
    }
}