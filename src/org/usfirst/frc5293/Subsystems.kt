package org.usfirst.frc5293

import org.usfirst.frc5293.subsystems.*
import org.usfirst.frc5293.util.Initializable
import org.usfirst.frc5293.util.LazyGroup

object Subsystems : Initializable {

    lateinit var drivetrain: Drivetrain
    lateinit var camera: Camera
    lateinit var cameraRingLight: CameraRingLight
    lateinit var shooter: Shooter
    lateinit var shooterKicker: ShooterKicker

    override fun init() {
        drivetrain = Drivetrain()
        camera = Camera()
        cameraRingLight = CameraRingLight()
        shooter = Shooter()
        shooterKicker = ShooterKicker()
    }
}
