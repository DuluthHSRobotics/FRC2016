package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.ShooterControl
import org.usfirst.frc5293.subsystems.util.MotorSubsystem

class Shooter : Subsystem(), MotorSubsystem {

    private val controller by lazy { Devices.shooter.controller }

    public override fun initDefaultCommand() {
        defaultCommand = ShooterControl()
    }

    override var power: Double
        get() = controller.get()
        set(x) {
            controller.set(x)
            SmartDashboard.putNumber("Shooter Power", x)
        }
}

