package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.CANTalon
import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.util.LiveWindowExt

class Device(val topMotor: SpeedController, val bottomMotor: SpeedController) {

    init {
        LiveWindowExt.tryAddActuator("Lift", "Bottom Motor", bottomMotor)

        if (bottomMotor is CANTalon) {
            bottomMotor.setVoltageRampRate(1.0 /* V/sec */)
        }
    }
}