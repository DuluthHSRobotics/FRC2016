package org.usfirst.frc5293.impl.systems.drivetrain

import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.controls.ToggleButtonControl
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainSubsystem

class DrivetrainModeControl(
        private val arcadeCommand: Command,
        private val tankCommand: Command,
        button: Button,
        drive: DrivetrainSubsystem) : ToggleButtonControl(button), Logging {

    override val subsystems: List<Subsystem> = listOf(drive)

    init {
        // Arcade by default
        // TODO: Make it an enum
        tankCommand.cancel()
        arcadeCommand.start()
    }

    override fun onToggle(isEnabled: Boolean) {
        val isArcade = isEnabled
        if (isArcade) {
            logger.debug("Arcade mode")
            tankCommand.cancel()
            arcadeCommand.start()
        } else {
            logger.debug("Tank mode")
            tankCommand.start()
            arcadeCommand.cancel()
        }
    }
}