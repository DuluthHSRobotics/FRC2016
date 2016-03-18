package org.usfirst.frc5293.framework.devices

import edu.wpi.first.wpilibj.interfaces.Accelerometer
import edu.wpi.first.wpilibj.interfaces.Gyro
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable

class AccelerometerDevice(name: String, accelerometer: Accelerometer) {
    init {
        if (accelerometer is Accelerometer && accelerometer is LiveWindowSendable)
            LiveWindow.addSensor("Sensors", name, accelerometer)
    }
}

class GyroDevice(val name: String, val sensor: Gyro) {
    init {
        if (sensor is Gyro && sensor is LiveWindowSendable)
            LiveWindow.addSensor("Sensors", name, sensor)
    }
}