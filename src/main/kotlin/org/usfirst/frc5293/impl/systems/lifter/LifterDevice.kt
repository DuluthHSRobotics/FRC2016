package org.usfirst.frc5293.impl.systems.lifter

import edu.wpi.first.wpilibj.CANTalon
import edu.wpi.first.wpilibj.SpeedController
import org.usfirst.frc5293.framework.util.LiveWindowExt
import org.usfirst.frc5293.framework.util.Logging

class LifterDevice(val windowMotor: SpeedController, val winchMotor: SpeedController): Logging {

    init {
        logger.info("WINDOW MOTOR WHERE ARE YOU!?")

        LiveWindowExt.tryAddActuator("Lift", "Bottom Motor", winchMotor)

        if (winchMotor is CANTalon) {
            winchMotor.setVoltageRampRate(1.0 /* V/sec */)
        }
    }
}