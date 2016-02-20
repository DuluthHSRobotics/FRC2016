package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.ShooterKickerControl

class ShooterKicker : Subsystem() {

    protected override fun initDefaultCommand() {
        defaultCommand = ShooterKickerControl()
    }

    var value: Double
        get() = Devices.getShooterKicker().kicker.get()
        set(x) {
            SmartDashboard.putNumber("Shooter Kicker", x)
            Devices.getShooterKicker().kicker.set(x)
        }

    var angle: Double
        get() = Devices.getShooterKicker().kicker.get() * 180.0
        set(angle) {
            SmartDashboard.putNumber("Shooter Kicker Angle", angle)
            Devices.getShooterKicker().kicker.angle = angle
        }
}