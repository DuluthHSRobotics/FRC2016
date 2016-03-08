package org.usfirst.frc5293.impl.systems.lifter

import edu.wpi.first.wpilibj.CANTalon
import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.framework.util.LiveWindowExt

class LifterDevice(val topMotor: SpeedController, val bottomMotor: SpeedController) {

    init {
        LiveWindowExt.tryAddActuator("Lift", "Bottom Motor", bottomMotor)

        if (bottomMotor is CANTalon) {
            bottomMotor.setVoltageRampRate(1.0 /* V/sec */)
        }
    }
}