package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.CANTalon
import edu.wpi.first.wpilibj.SpeedController

class Device(val topMotor: SpeedController, val bottomMotor: SpeedController) {

    init {
        if (bottomMotor is CANTalon) {
            bottomMotor.setVoltageRampRate(1.0 /* V/sec */)
        }
    }
}