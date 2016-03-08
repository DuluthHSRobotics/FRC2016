package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountSubsystem
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightSubsystem
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainSubsystem
import org.usfirst.frc5293.impl.systems.lifter.LifterSubsystem
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerSubsystem
import org.usfirst.frc5293.impl.systems.shooter.lifter.ShooterLifterSubsystem
import org.usfirst.frc5293.impl.systems.shooter.wheels.ShooterWheelsSubsystem

object Subsystems : LazyGroup() {

    val drivetrain by lazyByRequest {
        DrivetrainSubsystem(Devices.drivetrain)
    }

    object camera : LazyGroup(Subsystems) {

        val mount by lazyByRequest {
            CameraMountSubsystem(Devices.camera.mount)
        }

        val ringLight by lazyByRequest {
            CameraRingLightSubsystem(Devices.camera.ringLight)
        }
    }

    object shooter : LazyGroup(Subsystems) {

        val wheels by lazyByRequest {
            ShooterWheelsSubsystem(Devices.shooter.wheels)
        }

        val kicker by lazyByRequest {
            ShooterKickerSubsystem(Devices.shooter.kicker)
        }

        val lifter by lazyByRequest {
            ShooterLifterSubsystem(Devices.shooter.lifter)
        }
    }

    val lifter by lazyByRequest {
        LifterSubsystem(Devices.lift)
    }
}
