package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.interfaces.Accelerometer
import org.usfirst.frc5293.framework.devices.AccelerometerDevice
import org.usfirst.frc5293.framework.devices.GyroDevice
import org.usfirst.frc5293.framework.util.DelegatedLazyGroup
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.makeInverted
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountDevice
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightDevice
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainDevice
import org.usfirst.frc5293.impl.systems.lift.LiftDevice
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerDevice
import org.usfirst.frc5293.impl.systems.shooter.lift.ShooterLiftDevice
import org.usfirst.frc5293.impl.systems.shooter.limitswitch.ShooterBallLimitSwitchDevice
import org.usfirst.frc5293.impl.systems.shooter.wheels.ShooterWheelsDevice

/**
 * The Devices class is a central place where all the devices that are used by
 * the robot can be "wired" together. This allows for easily seeing what
 * everything is mapped to in a single file so that double-checking PWM cables
 * or changing them is quick and easy.
 */
object Devices : LazyGroup() {

    val drivetrain by lazyByRequest {
        DrivetrainDevice(
                frontLeft = Talon(1).makeInverted(),
                frontRight = Talon(2).makeInverted(),
                backLeft = Talon(0).makeInverted(),
                backRight = Talon(3).makeInverted())
    }

    object camera : DelegatedLazyGroup(Devices) {
        val mount by lazyByRequest {
            CameraMountDevice(
                    sideServo = Servo(5),
                    topServo = Servo(4))
        }

        val ringLight by lazyByRequest {
            CameraRingLightDevice(
                    relay = Relay(0, Relay.Direction.kForward))
        }
    }

    object shooter : DelegatedLazyGroup(Devices) {

        val wheels by lazyByRequest {
            ShooterWheelsDevice(
                    leftMotor = Victor(8).makeInverted(),
                    rightMotor = Victor(9))
        }

        val lift by lazyByRequest {
            ShooterLiftDevice(motor = Talon(6))
        }

        val kicker by Devices.lazyByRequest {
            ShooterKickerDevice(
                    servo = Servo(7))
        }

        val limitSwitch by Devices.lazyByRequest {
            ShooterBallLimitSwitchDevice(
                    limitSwitch = DigitalInput(0))
        }
    }

    val lift by lazyByRequest {
//        LiftDevice(
//                bottomMotor = CANTalon(0),
//                topMotor = CANTalon(1))
        LiftDevice(
                bottomMotor = Talon(4),
                topMotor = Talon(5)
        )
    }

    object sensors : DelegatedLazyGroup(Devices) {

        val builtInAccelerometer by lazyByRequest {
            AccelerometerDevice("Built-in Accelerometer",
                    BuiltInAccelerometer(Accelerometer.Range.k2G))
        }

        val accelerometer by lazyByRequest {
            AccelerometerDevice("Extra Accelerometer",
                    ADXL345_SPI(SPI.Port.kOnboardCS0, Accelerometer.Range.k2G))
        }

        val gyro by lazyByRequest {
            GyroDevice("Extra Gyro",
                    ADXRS450_Gyro(SPI.Port.kMXP))
        }
    }
}