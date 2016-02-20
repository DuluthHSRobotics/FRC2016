package org.usfirst.frc5293

import org.usfirst.frc5293.subsystems.*

object Subsystems {

    val drivetrain by lazy { Drivetrain() }

    val camera by lazy { Camera() }

    val cameraRingLight by lazy { CameraRingLight() }

    val shooter by lazy { Shooter() }

    val shooterKicker by lazy { ShooterKicker() }
}
