package org.usfirst.frc5293

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.input.*
import org.usfirst.frc5293.input.util.NullJoystick
import org.usfirst.frc5293.util.Initializable
import org.usfirst.frc5293.util.LazyGroup

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@Suppress("unused")
object Input : Initializable {

    private lateinit var joystick1: Joystick
    private lateinit var joystick2: Joystick
    private lateinit var joystick3: Joystick

    lateinit var drivetrain: DrivetrainTank
    lateinit var camera: Camera
    lateinit var cameraRingLight:CameraRingLight
    lateinit var shooter: Shooter
    lateinit var shooterKicker: ShooterKicker

    override fun init() {
        joystick1 = Joystick(0)
        joystick2 = Joystick(1)
        joystick3 = Joystick(2)

        drivetrain = DrivetrainTank(
                left = joystick1,
                right = joystick2)

        camera = Camera(NullJoystick)

        cameraRingLight = CameraRingLight(
                joystick = joystick3,
                button = JoystickButton(joystick3, 11))

        shooter = Shooter(joystick3)

        shooterKicker = ShooterKicker(joystick3,
                kickButton = JoystickButton(joystick3, 7))
    }
}

