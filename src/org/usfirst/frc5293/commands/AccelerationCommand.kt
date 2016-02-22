package org.usfirst.frc5293.commands

import edu.wpi.first.wpilibj.BuiltInAccelerometer
import edu.wpi.first.wpilibj.interfaces.Accelerometer
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.commands.util.EmptyCommand

class AccelerationCommand : EmptyCommand() {

    private lateinit var accelerometer: BuiltInAccelerometer

    override fun initialize() {
        accelerometer = BuiltInAccelerometer(Accelerometer.Range.k2G)
    }

    override fun execute() {
        SmartDashboard.putNumber("Acceleration X", accelerometer.x)
        SmartDashboard.putNumber("Acceleration Y", accelerometer.y)
        SmartDashboard.putNumber("Acceleration Z", accelerometer.z)
    }
}
