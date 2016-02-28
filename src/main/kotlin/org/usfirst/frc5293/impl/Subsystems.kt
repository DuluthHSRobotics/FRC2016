package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.util.DelegatedLazyGroup
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountSubsystem
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightSubsystem
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainSubsystem
import org.usfirst.frc5293.impl.systems.lift.LiftSubsystem
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerSubsystem
import org.usfirst.frc5293.impl.systems.shooter.lift.ShooterLiftSubsystem
import org.usfirst.frc5293.impl.systems.shooter.wheels.ShooterWheelsSubsystem

object Subsystems : LazyGroup() {

    val drivetrain by lazyByRequest {
        DrivetrainSubsystem(Devices.drivetrain)
    }

    object camera : DelegatedLazyGroup(Subsystems) {

        val mount by lazyByRequest {
            CameraMountSubsystem(Devices.camera.mount)
        }

        val ringLight by lazyByRequest {
            CameraRingLightSubsystem(Devices.camera.ringLight)
        }
    }

    object shooter : DelegatedLazyGroup(Subsystems) {

        val wheels by lazyByRequest {
            ShooterWheelsSubsystem(Devices.shooter.wheels)
        }

        val kicker by lazyByRequest {
            ShooterKickerSubsystem(Devices.shooter.kicker)
        }

        val lift by lazyByRequest {
            ShooterLiftSubsystem(Devices.shooter.lift)
        }
    }

    val lift by lazyByRequest {
        LiftSubsystem(Devices.lift)
    }
}
