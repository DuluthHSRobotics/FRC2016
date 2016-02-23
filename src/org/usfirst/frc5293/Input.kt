package org.usfirst.frc5293

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.input.*
import org.usfirst.frc5293.input.util.NullJoystick
import org.usfirst.frc5293.util.LazyGroup

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@Suppress("unused")
object Input : LazyGroup("Input") {

    private val joystick1 by lazyByRequest { Joystick(0) }
    private val joystick2 by lazyByRequest { Joystick(1) }
    private val joystick3 by lazyByRequest { Joystick(2) }

    val drivetrain by lazyByRequest {
        DrivetrainTank(
                left = joystick1,
                right = joystick2)
    }

    val camera by lazyByRequest {
        Camera(NullJoystick)
    }

    val cameraRingLight by lazyByRequest {
        val j = joystick3

        CameraRingLight(
                joystick = j,
                button = JoystickButton(j, 11))
    }

    val shooter by lazyByRequest {
        Shooter(joystick3)
    }

    val shooterKicker by lazyByRequest {
        val j = joystick3

        ShooterKicker(
                joystick = j,
                kickButton = JoystickButton(j, 7))
    }
}

