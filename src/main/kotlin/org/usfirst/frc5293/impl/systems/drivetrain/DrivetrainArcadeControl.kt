package org.usfirst.frc5293.impl.systems.drivetrain

import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.impl.Subsystems

class DrivetrainArcadeControl(private val input: DualDrivetrainInput) : EmptyCommand() {

    init {
        requires(Subsystems.drivetrain)
    }

    override fun execute() {
        Subsystems.drivetrain.driveArcade(
                power = input.leftJoystick.y,
                rotation = input.rightJoystick.twist
        )
    }

    override fun end() {
        Subsystems.drivetrain.stop()
    }
}
