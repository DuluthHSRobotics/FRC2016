package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc5293.framework.commands.ActionCommand
import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.framework.util.LazyControlGroup

object SensorControls : LazyControlGroup() {
    override val controls: List<*> by lazy {
        emptyList<Command>()
    }

//    val gyroResetCommand by lazyByRequest {
//        val x = GryoResetCommand()
//        SmartDashboard.putData("Reset Gyro", x)
//        x
//    }
}

class GyroReporterCommand : EmptyCommand() {

    val gyro = Devices.sensors.gyro.sensor

    override fun execute() {
        Prefs.sensors.gyroAngle.set(gyro.angle)
    }
}

class GryoResetCommand : ActionCommand() {
    override fun action() {
        Devices.sensors.gyro.sensor.reset()
    }
}