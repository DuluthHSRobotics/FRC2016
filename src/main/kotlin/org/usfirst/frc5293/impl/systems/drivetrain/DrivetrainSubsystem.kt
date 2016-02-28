package org.usfirst.frc5293.impl.systems.drivetrain

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.subsystems.EmptySubsytem
import org.usfirst.frc5293.impl.Devices

class DrivetrainSubsystem(private val drivetrain: DrivetrainDevice) : EmptySubsytem() {

    private val drive by lazy { drivetrain.control }

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

