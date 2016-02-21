package org.usfirst.frc5293.devices

import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj.SpeedController

class Drivetrain(val frontLeft: SpeedController, val frontRight: SpeedController, val backLeft: SpeedController, val backRight: SpeedController) {

    val control: RobotDrive

    init {
//        LiveWindow.addActuator("Drivetrain", "Front Left (Talon)", frontLeft)
//        LiveWindow.addActuator("Drivetrain", "Back Left (Talon)", backLeft)
//        LiveWindow.addActuator("Drivetrain", "Front Right (Talon)", frontRight)
//        LiveWindow.addActuator("Drivetrain", "Back Right (Talon)", backRight)

        control = RobotDrive(
                frontLeft, backLeft,
                frontRight, backRight)

        control.isSafetyEnabled = true
        control.expiration = 0.1
        control.setSensitivity(0.5)
        control.setMaxOutput(1.0)
    }
}