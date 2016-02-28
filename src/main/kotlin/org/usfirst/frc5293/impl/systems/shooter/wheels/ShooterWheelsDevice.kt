package org.usfirst.frc5293.impl.systems.shooter.wheels

import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.framework.devices.SpeedControllerGroup

class ShooterWheelsDevice(leftMotor: SpeedController, rightMotor: SpeedController) {
    val controller = SpeedControllerGroup(
            leftMotor,
            rightMotor)
}