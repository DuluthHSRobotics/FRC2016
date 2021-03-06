package org.usfirst.frc5293.impl.systems.lifter.windowmotor

import edu.wpi.first.wpilibj.CANTalon
import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.framework.util.LiveWindowExt
import org.usfirst.frc5293.framework.util.Logging

class LifterWindowMotorDevice(val motor: SpeedController): Logging {

    init {
        LiveWindowExt.tryAddActuator("Lift", "Window Motor", motor)

        //        if (motor is CANTalon) {
        //            motor.setVoltageRampRate(1.0 /* V/sec */)
        //        }
    }
}