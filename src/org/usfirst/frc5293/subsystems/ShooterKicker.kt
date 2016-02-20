package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.ShooterKickerControl

class ShooterKicker : Subsystem() {

    override fun initDefaultCommand() {
        defaultCommand = ShooterKickerControl()
    }

    private val servo = Devices.shooterKicker.kicker

    var value: Double
        get() = servo.get()
        set(x) {
            SmartDashboard.putNumber("Shooter Kicker", x)
            servo.set(x)
        }

    var angle: Double
        get() = servo.angle
        set(angle) {
            SmartDashboard.putNumber("Shooter Kicker Angle", angle)
            servo.angle = angle
        }
}