package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.ShooterControl

class Shooter : Subsystem() {

    private val controller by lazy { Devices.shooter.controller }

    public override fun initDefaultCommand() {
        defaultCommand = ShooterControl()
    }

    var power: Double
        get() = controller.get()
        set(x) {
            SmartDashboard.putNumber("Shooter Power", x)
            controller.set(x)
        }

    fun stop() {
        power = 0.0
    }
}

