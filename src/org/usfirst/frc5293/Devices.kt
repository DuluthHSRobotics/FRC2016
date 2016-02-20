package org.usfirst.frc5293

import org.usfirst.frc5293.devices.*

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object Devices {

    val drivetrain by lazy { Drivetrain() }

    val camera by lazy { Camera() }

    val cameraRingLight by lazy { CameraRingLight() }

    val shooter by lazy { Shooter() }

    val lifter by lazy { Shooter() }

    val shooterKicker by lazy { ShooterKicker() }
}
