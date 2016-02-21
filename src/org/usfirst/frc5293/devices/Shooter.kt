package org.usfirst.frc5293.devices

import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.devices.util.SpeedControllerGroup

class Shooter(leftMotor: SpeedController, rightMotor: SpeedController) {

    val controller = SpeedControllerGroup(
            leftMotor,
            rightMotor)
}

