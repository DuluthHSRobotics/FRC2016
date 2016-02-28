package org.usfirst.frc5293

import org.usfirst.frc5293.groups.shooter.lift.Subsystem as ShooterLift
import org.usfirst.frc5293.groups.lift.Subsystem as Lift
import org.usfirst.frc5293.subsystems.*
import org.usfirst.frc5293.util.LazyGroup

object Subsystems : LazyGroup("Subsystems") {

    val drivetrain by lazyByRequest { Drivetrain() }

    val camera by lazyByRequest { Camera() }

    val cameraRingLight by lazyByRequest { CameraRingLight() }

    val shooter by lazyByRequest { Shooter() }

    val shooterKicker by lazyByRequest { ShooterKicker() }

    val shooterLift by lazyByRequest { ShooterLift() }

    val lift by lazyByRequest { Lift() }
}
