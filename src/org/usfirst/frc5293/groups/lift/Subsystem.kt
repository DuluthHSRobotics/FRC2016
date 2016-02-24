package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.Devices

class Subsystem : Subsystem() {

    override fun initDefaultCommand() {
    }

    fun up() {
        Devices.lifter.bottomMotor.set(1.0)
    }

    fun down() {
        Devices.lifter.bottomMotor.set(-1.0)
    }

    fun stop() {
        Devices.lifter.bottomMotor.set(0.0)
    }
}