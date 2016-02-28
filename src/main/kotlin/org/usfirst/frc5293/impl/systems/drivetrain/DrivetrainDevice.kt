package org.usfirst.frc5293.impl.systems.drivetrain

import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.util.LiveWindowExt

class DrivetrainDevice(
        val frontLeft: SpeedController,
        val frontRight: SpeedController,
        val backLeft: SpeedController,
        val backRight: SpeedController) {

    val subsystem = "Drivetrain"

    val control: RobotDrive

    init {
        LiveWindowExt.tryAddActuator(subsystem, "Front Left", frontLeft)
        LiveWindowExt.tryAddActuator(subsystem, "Back Left", backLeft)
        LiveWindowExt.tryAddActuator(subsystem, "Front Right", frontRight)
        LiveWindowExt.tryAddActuator(subsystem, "Back Right", backRight)

        control = RobotDrive(
                frontLeft, backLeft,
                frontRight, backRight)

        control.isSafetyEnabled = true
        control.expiration = 0.1
        control.setSensitivity(0.5)
        control.setMaxOutput(1.0)
    }
}