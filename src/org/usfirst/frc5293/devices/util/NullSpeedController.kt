package org.usfirst.frc5293.devices.util

import edu.wpi.first.wpilibj.SpeedController

object NullSpeedController : SpeedController {

    private var isInverted = false

    override fun get(): Double {
        return 0.0
    }

    override fun set(speed: Double, syncGroup: Byte) {
    }

    override fun set(speed: Double) {
    }

    override fun setInverted(isInverted: Boolean) {
        this.isInverted = isInverted
    }

    override fun getInverted(): Boolean {
        return this.isInverted
    }

    override fun disable() {
    }

    override fun pidWrite(output: Double) {
    }
}
