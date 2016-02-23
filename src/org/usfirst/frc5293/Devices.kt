package org.usfirst.frc5293

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.interfaces.Accelerometer
import org.usfirst.frc5293.devices.*
import org.usfirst.frc5293.devices.util.NullSpeedController
import org.usfirst.frc5293.util.devices.makeInverted

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object Devices {

    val drivetrain by lazy {
        Drivetrain(
            frontLeft  = Talon(1).makeInverted(),
            frontRight = Talon(2).makeInverted(),
            backLeft   = Talon(0).makeInverted(),
            backRight  = Talon(3).makeInverted())
    }

    val camera by lazy {
        Camera(
            sideServo = Servo(5),
            topServo = Servo(4))
    }

    val cameraRingLight by lazy {
        CameraRingLight(
            relay = Relay(0, Relay.Direction.kForward))
    }

    val shooter by lazy {
        Shooter(
            leftMotor = Victor(8).makeInverted(),
            rightMotor = Victor(9))
    }

    val lifter by lazy {
        Lifter(
            bottomMotor = NullSpeedController,
            topMotor = NullSpeedController)
    }

    val shooterKicker by lazy {
        ShooterKicker(
            kicker = Servo(7))
    }

    val shooterBallLimitSwitch by lazy {
        ShooterBallLimitSwitch(
            limitSwitch = DigitalInput(0)
        )
    }

    val builtInAccelerometer by lazy {
        AccelerometerWrapped("Built-in Accelerometer",
                BuiltInAccelerometer(Accelerometer.Range.k2G))
    }

    val accelerometer by lazy {
        AccelerometerWrapped("Extra Accelerometer",
                ADXL345_SPI(SPI.Port.kOnboardCS0, Accelerometer.Range.k2G))
    }

    val gyro by lazy {
        AccelerometerWrapped("Built-in Accelerometer",
                BuiltInAccelerometer(Accelerometer.Range.k2G))
    }

    fun init() {
        drivetrain
        shooter
        shooterKicker
        shooterBallLimitSwitch
        builtInAccelerometer
        accelerometer
        gyro
    }
}