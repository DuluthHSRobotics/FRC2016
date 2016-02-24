package org.usfirst.frc5293

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.interfaces.Accelerometer
import org.usfirst.frc5293.devices.*
import org.usfirst.frc5293.devices.util.NullSpeedController
import org.usfirst.frc5293.groups.lift.Device as Lift
import org.usfirst.frc5293.util.*

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
@Suppress("unused")
object Devices : LazyGroup("Devices") {

    val drivetrain by lazyByRequest {
        Drivetrain(
                frontLeft = Talon(1).makeInverted(),
                frontRight = Talon(2),
                backLeft = Talon(0).makeInverted(),
                backRight = Talon(3))
    }

    val camera by lazyByRequest {
        Camera(
                sideServo = Servo(5),
                topServo = Servo(4))
    }

    val cameraRingLight by lazyByRequest {
        CameraRingLight(
                relay = Relay(0, Relay.Direction.kForward))
    }

    val shooter by lazyByRequest {
        Shooter(leftMotor = Victor(8).makeInverted(),
                rightMotor = Victor(9))
    }

    val lifter by lazyByRequest {
        Lift(bottomMotor = NullSpeedController,
             topMotor = NullSpeedController)
    }

    val shooterKicker by lazyByRequest {
        ShooterKicker(
                kicker = Servo(7))
    }

    val shooterBallLimitSwitch by lazyByRequest {
        ShooterBallLimitSwitch(
                limitSwitch = DigitalInput(0))
    }

    val builtInAccelerometer by lazyByRequest {
        AccelerometerWrapped("Built-in Accelerometer",
                BuiltInAccelerometer(Accelerometer.Range.k2G))
    }

    val accelerometer by lazyByRequest {
        AccelerometerWrapped("Extra Accelerometer",
                ADXL345_SPI(SPI.Port.kOnboardCS0, Accelerometer.Range.k2G))
    }

    val gyro by lazyByRequest {
        AccelerometerWrapped("Built-in Accelerometer",
                BuiltInAccelerometer(Accelerometer.Range.k2G))
    }
}