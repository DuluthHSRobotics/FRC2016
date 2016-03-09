package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import org.usfirst.frc5293.framework.controls.*
import org.usfirst.frc5293.framework.input.NullJoystick
import org.usfirst.frc5293.framework.util.Initializable
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.LazySink
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountControl
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountInput
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightControl
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainTankControl
import org.usfirst.frc5293.impl.systems.drivetrain.DualDrivetrainInput
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

    object drivetrain {

        val input by Controls.lazyByRequest {
            DualDrivetrainInput(
                    leftJoystick = joystick1,
                    rightJoystick = joystick2)
        }

        val control by Controls.lazyByRequest {
            DrivetrainTankControl(input)
        }
    }

    init { subgroups.add(drivetrain) }

    object camera {

        object mount {

            val joystick by Controls.lazyByRequest {
                NullJoystick
            }

            val originButton by Controls.lazyByRequest {
                joystick.button(4) // TODO: Can't remember which button it is...
            }

            val input by Controls.lazyByRequest {
                CameraMountInput(
                        x = { joystick.twist },
                        y = { joystick.y},
                        originButton = originButton)
            }

            val control by Controls.lazyByRequest {
                CameraMountControl(input, Subsystems.camera.mount)
            }
        }

        init { Controls.subgroups.add(mount) }

        object ringLight {

            val joystick by Controls.lazyByRequest {
                NullJoystick
            }

            val input by Controls.lazyByRequest {
                joystick.button(11)
            }

            val control by Controls.lazyByRequest {
                CameraRingLightControl(input, Subsystems.camera.ringLight)
            }
        }

        init { Controls.subgroups.add(ringLight) }
    }

    init { Controls.subgroups.add(camera) }

    object shooter {

        object wheels {

            val joystick by Controls.lazyByRequest {
                joystick3
            }

            val input by Controls.lazyByRequest {
                SingleAxisButtonInput(
                        positiveButton = joystick.button(6),
                        negativeButton = joystick.button(4))
            }

            val power = SingleAxisPowerSettings(
                    positivePower = 1.0,
                    negativePower = -0.3
            )

            val control by Controls.lazyByRequest {
                SingleAxisButtonControl(input, power, Subsystems.shooter.wheels)
            }
        }

        init { Controls.subgroups.add(wheels) }

        object kicker {

            val joystick by Controls.lazyByRequest {
                joystick3
            }

            val button by Controls.lazyByRequest {
                joystick.button(1)
            }

            val control by Controls.lazyByRequest {
                ShooterKickerControl(button, Subsystems.shooter.kicker)
            }
        }

        init { Controls.subgroups.add(kicker) }

        object lifter {

            val input by Controls.lazyByRequest {
                { joystick3.y }
            }

            val control by Controls.lazyByRequest {
                DeadzoneMotorSubsystemControl(input, Subsystems.shooter.lifter)
            }
        }

        init { Controls.subgroups.add(lifter) }
    }

    init { Controls.subgroups.add(shooter) }

    object lifter {

        object winchMotor {
            val joystick by Controls.lazyByRequest {
                joystick3
            }

            val input by Controls.lazyByRequest {
                SingleAxisButtonInput(
                        positiveButton = joystick.button(9),
                        negativeButton = joystick.button(11)
                )
            }

            val power by Controls.lazyByRequest {
                SingleAxisPowerSettings(
                        positivePower = 1.0,
                        negativePower = -1.0
                )
            }

            val control by Controls.lazyByRequest {
                SingleAxisButtonControl(input, power, Subsystems.winchMotor)
            }
        }

        init { Controls.subgroups.add(winchMotor) }

        object windowMotor {

            val joystick by Controls.lazyByRequest {
                joystick2
            }

            val input by Controls.lazyByRequest {
                SingleAxisButtonInput(
                        positiveButton = joystick.button(10),
                        negativeButton = joystick.button(12)
                )
            }

            val controlInput by Controls.lazyByRequest {
                {
                    val raw = joystick.twist
                    val power = if (Math.abs(raw) > 0.10) raw else 0.0
                    val scale = Prefs.root.winchSpeedScale.get()
                    power * scale
                }
            }

            val childControl by Controls.lazyByRequest {
                RawMotorSubsystemControl(controlInput, Subsystems.windowMotor)
            }

            val button by Controls.lazyByRequest {
                joystick.button(1)
            }

            val control by Controls.lazyByRequest {
                HookedControl({ button.get() }, childControl)
            }
        }

        init { Controls.subgroups.add(windowMotor) }
    }

    init { Controls.subgroups.add(lifter) }

    val controls: List<*> by lazy {
        listOf(drivetrain.control,
                shooter.wheels.control,
                shooter.kicker.control,
                shooter.lifter.control,
                lifter.winchMotor.control,
                lifter.windowMotor.childControl,
                lifter.windowMotor.control)
    }

    override fun init() {
        super.init()
        initCommands()
    }

    private fun initCommands() {
        controls.forEach {
            if (it is Initializable) {
                it.init()
            }

            if (it is Command) {
                Scheduler.getInstance().add(it)
            }
        }
    }

    fun startAll() {
        controls.forEach {
            if (it is Command) {
                it.start()
            }
        }

        logger.info("Started ${controls.count()} commands")
    }

    fun cancelAll() {
        controls.forEach {
            when (it) {
                is Command ->
                    it.cancel()
            }
        }

        logger.info("Canceled ${controls.count()} commands")
    }
}

fun Joystick.button(buttonNumber: Int) = JoystickButton(this, buttonNumber)

