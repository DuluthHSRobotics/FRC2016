package org.usfirst.frc5293.impl

import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountSubsystem
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightSubsystem
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainSubsystem
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerSubsystem
import org.usfirst.frc5293.impl.systems.shooter.wheels.ShooterWheelsSubsystem

object Subsystems : LazyGroup() {

    val drivetrain by lazyByRequest {
        DrivetrainSubsystem(Devices.drivetrain)
    }

    object camera {
        val mount by Subsystems.lazyByRequest {
            CameraMountSubsystem(Devices.camera.mount)
        }

        val ringLight by Subsystems.lazyByRequest {
            CameraRingLightSubsystem(Devices.camera.ringLight)
        }
    }

    init { subgroups.add(camera) }

    object shooter {

        val wheels by Subsystems.lazyByRequest {
            ShooterWheelsSubsystem(Devices.shooter.wheels)
        }

        val kicker by Subsystems.lazyByRequest {
            ShooterKickerSubsystem(Devices.shooter.kicker)
        }

        val lifter by Subsystems.lazyByRequest {
            MotorSubsystem(Devices.shooter.lifter)
        }
    }

    init { subgroups.add(shooter) }

    val winchMotor by Subsystems.lazyByRequest {
        MotorSubsystem(Devices.lifter.winchMotor.motor)
    }

    val windowMotor by Subsystems.lazyByRequest {
        MotorSubsystem(Devices.lifter.windowMotor.motor)
    }
}
