package org.usfirst.frc5293.util

import edu.wpi.first.wpilibj.livewindow.LiveWindow
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable

// As of with Kotlin 1.0, we can't make extensions methods on Java class with static methods

object LiveWindowExt {
    fun <T> tryAddActuator(subsystem: String, name: String, device: T) {
        if (device is LiveWindowSendable)
            LiveWindow.addActuator(subsystem, name, device)
    }
}