package org.usfirst.frc5293.subsystems

import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.Devices
import org.usfirst.frc5293.commands.teleop.control.DrivetrainControl

class Drivetrain : Subsystem() {

    private val drive by lazy { Devices.drivetrain.control }

    override fun initDefaultCommand() {
        defaultCommand = DrivetrainControl()
    }

    fun driveArcade(power: Double, rotation: Double) {
        // TODO: Just for debug right now
        SmartDashboard.putNumber("Joystick Power", power)
        SmartDashboard.putNumber("Joystick Rot", rotation)

        drive.arcadeDrive(power, rotation)

        SmartDashboard.putNumber("Front Left", Devices.drivetrain.frontLeft.get())
        SmartDashboard.putNumber("Front Right", Devices.drivetrain.frontRight.get())
        SmartDashboard.putNumber("Back Left", Devices.drivetrain.backLeft.get())
        SmartDashboard.putNumber("Back Right", Devices.drivetrain.backRight.get())
    }

    fun driveTank(leftPower: Double, rightPower: Double) {
        // TODO: Just for debug right now
        SmartDashboard.putNumber("Joystick Left Power", leftPower)
        SmartDashboard.putNumber("Joystick Right Power", rightPower)

        drive.tankDrive(leftPower, rightPower)

        SmartDashboard.putNumber("Front Left", Devices.drivetrain.frontLeft.get())
        SmartDashboard.putNumber("Front Right", Devices.drivetrain.frontRight.get())
        SmartDashboard.putNumber("Back Left", Devices.drivetrain.backLeft.get())
        SmartDashboard.putNumber("Back Right", Devices.drivetrain.backRight.get())
    }

    fun stop() {
        drive.drive(0.0, 0.0)
    }
}

