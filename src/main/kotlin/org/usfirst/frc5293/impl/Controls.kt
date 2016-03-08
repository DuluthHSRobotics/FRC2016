package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import org.usfirst.frc5293.framework.controls.MotorSubsystemControl
import org.usfirst.frc5293.framework.controls.SingleAxisButtonControl
import org.usfirst.frc5293.framework.controls.SingleAxisButtonInput
import org.usfirst.frc5293.framework.controls.SingleAxisPowerSettings
import org.usfirst.frc5293.framework.input.NullJoystick
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.LazySink
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountControl
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountInput
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightControl
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainTankControl
import org.usfirst.frc5293.impl.systems.drivetrain.DualDrivetrainInput
import org.usfirst.frc5293.impl.systems.lifter.LifterControl
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerControl
import kotlin.reflect.KClass

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
object Controls : LazyGroup() {

    private val commandSink = LazySink()

    override fun onChooseSink(clazz: KClass<*>, defaultSink: LazySink): LazySink {
        // filter anything that is a subclass of a command which needs to get registered separately
        val isCommand = clazz.java.isAssignableFrom(Command::class.java)

        return if (isCommand)
            commandSink
        else
            defaultSink
    }

    private val joystick1 by lazyByRequest { Joystick(0) }
    private val joystick2 by lazyByRequest { Joystick(1) }
    private val joystick3 by lazyByRequest { Joystick(2) }

    object drivetrain : LazyGroup(asChild) {

        val input by lazyByRequest {
            DualDrivetrainInput(
                    leftJoystick = joystick1,
                    rightJoystick = joystick2)
        }

        val control by lazyByRequest {
            DrivetrainTankControl(input)
        }
    }

    object camera : LazyGroup(asChild) {

        object mount : LazyGroup(asChild) {

            val joystick by lazyByRequest {
                NullJoystick
            }

            val originButton by lazyByRequest {
                joystick.button(4) // TODO: Can't remember which button it is...
            }

            val input by lazyByRequest {
                CameraMountInput(
                        x = { joystick.twist },
                        y = { joystick.y},
                        originButton = originButton)
            }

            val control by lazyByRequest {
                CameraMountControl(input, Subsystems.camera.mount)
            }
        }

        object ringLight: LazyGroup(asChild) {

            val joystick by lazyByRequest {
                NullJoystick
            }

            val input by lazyByRequest {
                joystick.button(11)
            }

            val control by lazyByRequest {
                CameraRingLightControl(input, Subsystems.camera.ringLight)
            }
        }
    }

    object shooter : LazyGroup(asChild) {

        object wheels : LazyGroup(asChild) {

            val joystick by lazyByRequest {
                joystick2
            }

            val input by lazyByRequest {
                SingleAxisButtonInput(
                        positiveButton = joystick.button(3),
                        negativeButton = joystick.button(5))
            }

            val power = SingleAxisPowerSettings(
                    positivePower = 1.0,
                    negativePower = -0.3
            )

            val control by lazyByRequest {
                SingleAxisButtonControl(input, power, Subsystems.shooter.wheels)
            }
        }

        object kicker : LazyGroup(asChild) {

            val joystick by lazyByRequest {
                joystick2
            }

            val button by lazyByRequest {
                joystick.button(10)
            }

            val control by lazyByRequest {
                ShooterKickerControl(button, Subsystems.shooter.kicker)
            }
        }

        object lifter : LazyGroup(asChild) {

            val joystick = NullJoystick

            val input by lazyByRequest {
                { joystick.y }
            }

            val control by lazyByRequest {
                MotorSubsystemControl(input, Subsystems.shooter.lifter)
            }
        }
    }

    object lifter : LazyGroup(asChild) {

        val button by lazyByRequest {
            joystick3.button(10)
        }

        val control by lazyByRequest {
            LifterControl(button, Subsystems.lifter)
        }
    }

    private fun forEach(action: (Command) -> Unit) {
        commandSink.registrations.forEach {
            when (it) {
                is Command -> action(it)
            }
        }
    }

    fun startAll() {
        forEach { it.start() }
    }

    fun cancelAll() {
        forEach { it.cancel() }
    }
}

fun Joystick.button(buttonNumber: Int) = JoystickButton(this, buttonNumber)

