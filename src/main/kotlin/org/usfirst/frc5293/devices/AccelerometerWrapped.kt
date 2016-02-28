package org.usfirst.frc5293.devices

import edu.wpi.first.wpilibj.interfaces.Accelerometer
import edu.wpi.first.wpilibj.interfaces.Gyro
import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable

class AccelerometerWrapped(name: String, accelerometer: Accelerometer) {
    init {
        if (accelerometer is Accelerometer && accelerometer is LiveWindowSendable)
            LiveWindow.addSensor("Sensors", name, accelerometer)
    }
}

class GyroWrapped(name: String, gyro: Gyro) {
    init {
        if (gyro is Gyro && gyro is LiveWindowSendable)
            LiveWindow.addSensor("Sensors", name, gyro)
    }
}