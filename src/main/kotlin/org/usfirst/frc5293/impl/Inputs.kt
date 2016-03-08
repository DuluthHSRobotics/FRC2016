package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.controls.MotorSubsystemControl
import org.usfirst.frc5293.framework.controls.PushDownButtonControl
import org.usfirst.frc5293.framework.input.NullJoystick
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountInput
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightInput
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainTankControl
import org.usfirst.frc5293.impl.systems.drivetrain.DualDrivetrainInput
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerInput
import org.usfirst.frc5293.impl.systems.shooter.lift.ShooterLiftInput as ShooterLift

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
        val input =
                DualDrivetrainInput(
                    leftJoystick = joystick1,
                    rightJoystick = joystick2)

        val control = DrivetrainTankControl(input)
    }

    val camera by lazyByRequest {
        CameraMountInput(NullJoystick, Subsystems.camera.mount)
    }

    val cameraRingLight by lazyByRequest {
        val j = NullJoystick

        CameraRingLightInput(
                joystick = j,
                button = j.button(11),
                ringLight = Subsystems.camera.ringLight)
    }

    val shooter by lazyByRequest {
        val j = joystick2
//        Shooter(inButton = j.button(3),
//                outButton = j.button(5))
//        MotorSubsystemControl({ j.y }, Subsystems.shooter.wheels)
    }

    val shooterKicker by lazyByRequest {
        val j = NullJoystick

        ShooterKickerInput(
                joystick = j,
                kickButton = j.button(10),
                subsystem = Subsystems.shooter.kicker)
    }

    val shooterLifter by lazyByRequest {
        val j = NullJoystick

//        org.usfirst.frc5293.impl.systems.shooter.lift.ShooterLiftInput(
//                joystick = j)
    }

    val lifter by lazyByRequest {
        val j = joystick3

//        Lift(upButton = j.button(9),
//             downButton = j.button(11))
        val x = object : PushDownButtonControl(j.button(11)) {
            override val subsystems: List<Subsystem>
                get() = listOf(Subsystems.lift)

            override fun onPressed() {
                Subsystems.lift.power = 1.0
            }

            override fun onReleased() {
                Subsystems.lift.stop()
            }
        }
    }
}

fun Joystick.button(buttonNumber: Int) = JoystickButton(this, buttonNumber)

