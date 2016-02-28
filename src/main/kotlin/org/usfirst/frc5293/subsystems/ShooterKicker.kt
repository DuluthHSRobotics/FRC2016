package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.ShooterKickerControl
import org.usfirst.frc5293.subsystems.util.ServoSubsystem

class ShooterKicker : Subsystem(), ServoSubsystem {

    private val servo by lazy { Devices.shooterKicker.kicker }

    override fun initDefaultCommand() {
        defaultCommand = ShooterKickerControl()
    }

    override var value: Double
        get() = servo.get()
        set(x) {
            SmartDashboard.putNumber("Shooter Kicker", x)
            servo.set(x)
        }

    override var angle: Double
        get() = servo.angle
        set(angle) {
            SmartDashboard.putNumber("Shooter Kicker Angle", angle)
            servo.angle = angle
        }
}