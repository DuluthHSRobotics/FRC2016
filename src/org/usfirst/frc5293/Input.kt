package org.usfirst.frc5293

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.input.*
import org.usfirst.frc5293.input.util.NullJoystick

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
object Input {

    private val joystick1 by lazy { Joystick(0) }
    private val joystick2 by lazy { Joystick(1) }
    private val joystick3 by lazy { Joystick(2) }

    private val None = NullJoystick.getInstance()

    val drivetrain by lazy { DrivetrainTank(None, None) }

    val camera by lazy { Camera(None) }

    val cameraRingLight by lazy { CameraRingLight(joystick3) }

    val shooter by lazy { Shooter(joystick1) }

    val shooterKicker by lazy {
        val joystick = joystick2

        ShooterKicker(joystick,
                kickButton = JoystickButton(joystick, 7))
    }
}

