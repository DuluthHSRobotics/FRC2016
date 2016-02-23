package org.usfirst.frc5293.devices

import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable

class Drivetrain(
        val frontLeft: SpeedController,
        val frontRight: SpeedController,
        val backLeft: SpeedController,
        val backRight: SpeedController) {

    val subsystem = "Drivetrain"

    val control: RobotDrive

    init {
        tryHookToLiveWindow("Front Left", frontLeft)
        tryHookToLiveWindow("Back Left", backLeft)
        tryHookToLiveWindow("Front Right", frontRight)
        tryHookToLiveWindow("Back Right", backRight)

        control = RobotDrive(
                frontLeft, backLeft,
                frontRight, backRight)

        control.isSafetyEnabled = true
        control.expiration = 0.1
        control.setSensitivity(0.5)
        control.setMaxOutput(1.0)
    }

    private fun <T> tryHookToLiveWindow(name: String, device: T) {
        if (device is LiveWindowSendable)
            LiveWindow.addActuator(subsystem, name, device)
    }
}