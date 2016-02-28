package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.Prefs
import org.usfirst.frc5293.commands.teleop.control.Lift

class Subsystem : Subsystem() {

    override fun initDefaultCommand() {
        defaultCommand = Lift()
    }

    var power: Double
        get() = Devices.lifter.bottomMotor.get()
        set(value) = Devices.lifter.bottomMotor.set(value)
}