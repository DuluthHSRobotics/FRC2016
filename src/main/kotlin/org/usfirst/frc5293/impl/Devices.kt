package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.interfaces.Accelerometer
import org.usfirst.frc5293.framework.devices.AccelerometerDevice
import org.usfirst.frc5293.framework.devices.GyroDevice
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.makeInverted
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountDevice
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightDevice
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainDevice
import org.usfirst.frc5293.impl.systems.lifter.winchmotor.LifterWinchMotorDevice
import org.usfirst.frc5293.impl.systems.lifter.windowmotor.LifterWindowMotorDevice
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerDevice
import org.usfirst.frc5293.impl.systems.shooter.limitswitch.ShooterBallLimitSwitchDevice
import org.usfirst.frc5293.impl.systems.shooter.wheels.ShooterWheelsDevice

/**
 * The Devices class is a central place where all the devices that are used by
 * the robot can be "wired" together. This allows for easily seeing what
 * everything is mapped to in a single file so that double-checking PWM cables
 * or changing them is quick and easy.
 */
object Devices : LazyGroup() {

    private enum class ConfigSet {
        PROTOTYPE,
        COMPETITION
    }

    // TODO: Might want to refactor this somewhere else
    private val currentConfig = ConfigSet.COMPETITION

//    private val isCameraEnabled = false

    val drivetrain by lazyByRequest {
        DrivetrainDevice(
                frontLeft = Talon(1).makeInverted(),
                frontRight = Talon(2).makeInverted(),
                backLeft = Talon(0).makeInverted(),
                backRight = Talon(3).makeInverted())
    }

    object camera {
        val mount: CameraMountDevice? by Devices.lazyByRequest {
            null
        }

        val ringLight by Devices.lazyByRequest {
            CameraRingLightDevice(
                    relay = Relay(0, Relay.Direction.kForward))
        }
    }

    init { subgroups.add(camera) }

    object shooter {

        val wheels by Devices.lazyByRequest {
            ShooterWheelsDevice(
                    leftMotor = Victor(8).makeInverted(),
                    rightMotor = Victor(9))
        }

        val lifter by Devices.lazyByRequest {
            when (currentConfig) {
                ConfigSet.PROTOTYPE -> Victor(6) as SpeedController
                ConfigSet.COMPETITION -> Talon(6) as SpeedController
            }
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

    init { subgroups.add(shooter) }

    object lifter {

        val winchMotor by Devices.lazyByRequest {
            when (currentConfig) {
                ConfigSet.PROTOTYPE ->
                        LifterWinchMotorDevice(Victor(4))
                ConfigSet.COMPETITION ->
                        LifterWinchMotorDevice(CANTalon(1))
            }
        }

        val windowMotor by Devices.lazyByRequest {
            when (currentConfig) {
                ConfigSet.PROTOTYPE ->
                    LifterWindowMotorDevice(Victor(5))
                ConfigSet.COMPETITION ->
                    LifterWindowMotorDevice(CANTalon(0))
            }
        }
    }

    init { subgroups.add(lifter) }

    object sensors {

        val builtInAccelerometer by Devices.lazyByRequest {
            AccelerometerDevice("Built-in Accelerometer",
                    BuiltInAccelerometer(Accelerometer.Range.k2G))
        }

        val accelerometer by Devices.lazyByRequest {
            AccelerometerDevice("Extra Accelerometer",
                    ADXL345_SPI(SPI.Port.kOnboardCS0, Accelerometer.Range.k2G))
        }

        val gyro by Devices.lazyByRequest {
            GyroDevice("Extra Gyro",
                    ADXRS450_Gyro(SPI.Port.kMXP))
        }
    }

    init { subgroups.add(sensors) }
}