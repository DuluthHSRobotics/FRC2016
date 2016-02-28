package org.usfirst.frc5293

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.groups.lift.Lift
import org.usfirst.frc5293.input.*
import org.usfirst.frc5293.input.util.NullJoystick
import org.usfirst.frc5293.util.LazyGroup
import org.usfirst.frc5293.groups.shooter.lift.Input as ShooterLift

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@Suppress("unused")
object Inputs : LazyGroup() {

    private val joystick1 by lazyByRequest { Joystick(0) }
    private val joystick2 by lazyByRequest { Joystick(1) }
    private val joystick3 by lazyByRequest { Joystick(2) }

    val drivetrain by lazyByRequest {
        DrivetrainArcade(
                powerJoystick = joystick1,
                rotationJoystick = joystick2)
    }

    val camera by lazyByRequest {
        Camera(NullJoystick)
    }

    val cameraRingLight by lazyByRequest {
        val j = NullJoystick

        CameraRingLight(
                joystick = j,
                button = j.button(11))
    }

    val shooter by lazyByRequest {
        val j = joystick2
//        Shooter(inButton = j.button(3),
//                outButton = j.button(5))
        Shooter(j)
    }

    val shooterKicker by lazyByRequest {
        val j = NullJoystick

        ShooterKicker(
                joystick = j,
                kickButton = j.button(10))
    }

    val shooterLifter by lazyByRequest {
        val j = NullJoystick

        ShooterLift(
                joystick = j)
    }

    val lifter by lazyByRequest {
        val j = joystick3

//        Lift(upButton = j.button(9),
//             downButton = j.button(11))
        Lift(j)
    }
}

fun Joystick.button(buttonNumber: Int) = JoystickButton(this, buttonNumber)

