package org.usfirst.frc5293

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.interfaces.Accelerometer
import org.usfirst.frc5293.devices.*
import org.usfirst.frc5293.devices.util.NullSpeedController
import org.usfirst.frc5293.util.*

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
@Suppress("unused")
object Devices : Initializable {

    lateinit var drivetrain: Drivetrain

    override fun init() {
        drivetrain = Drivetrain(
                frontLeft = Talon(1).makeInverted(),
                frontRight = Talon(2).makeInverted(),
                backLeft = Talon(0).makeInverted(),
                backRight = Talon(3).makeInverted())

        camera = Camera(
                sideServo = Servo(5),
                topServo = Servo(4))

        cameraRingLight = CameraRingLight(Relay(0, Relay.Direction.kForward))

        shooter = Shooter(
                leftMotor = Victor(8).makeInverted(),
                rightMotor = Victor(9))

        lifter = Lifter(
                bottomMotor = NullSpeedController,
                topMotor = NullSpeedController)

        shooterKicker = ShooterKicker(
                kicker = Servo(7))

        shooterBallLimitSwitch = ShooterBallLimitSwitch(
                limitSwitch = DigitalInput(0))

        builtInAccelerometer = AccelerometerWrapped("Built-in Accelerometer",
                BuiltInAccelerometer(Accelerometer.Range.k2G))

        accelerometer = AccelerometerWrapped("Extra Accelerometer",
                ADXL345_SPI(SPI.Port.kOnboardCS0, Accelerometer.Range.k2G))
    }

    lateinit var shooter: Shooter

    lateinit var camera: Camera

    lateinit var cameraRingLight: CameraRingLight

    lateinit var lifter: Lifter

    lateinit var shooterKicker: ShooterKicker

    lateinit var shooterBallLimitSwitch: ShooterBallLimitSwitch

    lateinit var builtInAccelerometer: AccelerometerWrapped

    lateinit var accelerometer: AccelerometerWrapped
}