package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import org.usfirst.frc5293.framework.controls.MotorSubsystemControl
import org.usfirst.frc5293.framework.controls.SingleAxisButtonControl
import org.usfirst.frc5293.framework.controls.SingleAxisButtonInput
import org.usfirst.frc5293.framework.controls.SingleAxisPowerSettings
import org.usfirst.frc5293.framework.input.NullJoystick
import org.usfirst.frc5293.framework.util.DelegatedLazyGroup
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.LazySink
import org.usfirst.frc5293.framework.util.Logging
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
@Suppress("unused")
object Controls : LazyGroup(), Logging {

    private val joystick1 by lazyByRequest { Joystick(0) }
    private val joystick2 by lazyByRequest { Joystick(1) }
    private val joystick3 by lazyByRequest { Joystick(2) }

    object drivetrain : DelegatedLazyGroup(Controls) {

        val input by lazyByRequest {
            DualDrivetrainInput(
                    leftJoystick = joystick1,
                    rightJoystick = joystick2)
        }

        val control by lazyByRequest {
            println("INIT DRIVE")
            DrivetrainTankControl(input)
        }
    }

    object camera : DelegatedLazyGroup(Controls) {

        object mount : DelegatedLazyGroup(camera) {

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

        object ringLight: DelegatedLazyGroup(camera) {

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

    object shooter : DelegatedLazyGroup(Controls) {

        object wheels : DelegatedLazyGroup(shooter) {

            init {
                println("======= !!! HAHA IT WORKS !!! ==========")
            }

            val joystick by lazyByRequest {
                NullJoystick
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

        object kicker : DelegatedLazyGroup(shooter) {

            val joystick by lazyByRequest {
                NullJoystick
            }

            val button by lazyByRequest {
                joystick.button(10)
            }

            val control by lazyByRequest {
                ShooterKickerControl(button, Subsystems.shooter.kicker)
            }
        }

        object lifter : DelegatedLazyGroup(shooter) {

            val joystick = NullJoystick

            val input by lazyByRequest {
                { joystick.y }
            }

            val control by lazyByRequest {
                MotorSubsystemControl(input, Subsystems.shooter.lifter)
            }
        }
    }

    object lifter : DelegatedLazyGroup(Controls) {

        val joystick by lazyByRequest {
            NullJoystick
        }

        val button by lazyByRequest {
            joystick.button(10)
        }

        val control by lazyByRequest {
            LifterControl(button, Subsystems.lifter)
        }
    }

    private fun forEach(action: (Command) -> Unit) {
        sink.registrations
                .mapNotNull { it as? Command }
                .forEach { action(it) }
    }

    fun startAll() {
        this.forEach { it.start() }
        logger.info("Started ${sink.registrations.count()} commands")
    }

    fun cancelAll() {
        this.forEach { it.cancel() }
        logger.info("Canceled ${sink.registrations.count()} commands")
    }
}

fun Joystick.button(buttonNumber: Int) = JoystickButton(this, buttonNumber)

