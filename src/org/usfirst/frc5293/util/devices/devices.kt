package org.usfirst.frc5293.util.devices

import edu.wpi.first.wpilibj.SpeedController

fun <T : SpeedController> T.makeInverted(): T {
    this.inverted = true
    return this
}