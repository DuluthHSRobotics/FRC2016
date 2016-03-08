package org.usfirst.frc5293.impl.systems.drivetrain

import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.impl.Subsystems

class DrivetrainTankControl(private val input: DualDrivetrainInput) : EmptyCommand() {

    init {
        requires(Subsystems.drivetrain)
    }

    override fun execute() {
        Subsystems.drivetrain.driveTank(
                leftPower = input.leftJoystick.y,
                rightPower = input.rightJoystick.y
        )
    }

    override fun end() {
        Subsystems.drivetrain.stop()
    }
}
