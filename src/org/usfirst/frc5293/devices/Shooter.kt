package org.usfirst.frc5293.devices

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Servo
import edu.wpi.first.wpilibj.SpeedController
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import org.usfirst.frc5293.devices.util.SpeedControllerGroup

class Shooter(leftMotor: SpeedController, rightMotor: SpeedController) {
    val controller = SpeedControllerGroup(
            leftMotor,
            rightMotor)
}

class ShooterKicker(val kicker: Servo)

class ShooterBallLimitSwitch(val limitSwitch: DigitalInput) {
    init {
        LiveWindow.addSensor("Shooter", "Ball Limit Switch", limitSwitch)
    }
}