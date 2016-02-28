package org.usfirst.frc5293.groups.shooter.lift

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices

class Subsystem : Subsystem() {

    override fun initDefaultCommand() {
        defaultCommand = Control()
    }

    var power: Double
        get() = Devices.shooterLift.motor.get()
        set(value) {
            SmartDashboard.putNumber("Shooter Lift", value)
            return Devices.shooterLift.motor.set(value)
        }

    fun stop() = {
        power = 0.0
    }
}