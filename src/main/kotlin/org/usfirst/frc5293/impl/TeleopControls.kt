package org.usfirst.frc5293.impl

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import org.usfirst.frc5293.framework.controls.*
import org.usfirst.frc5293.framework.input.NullJoystick
import org.usfirst.frc5293.framework.util.Initializable
import org.usfirst.frc5293.framework.util.LazyGroup
import org.usfirst.frc5293.framework.util.Logging
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountControl
import org.usfirst.frc5293.impl.systems.camera.mount.CameraMountInput
import org.usfirst.frc5293.impl.systems.camera.ringlight.CameraRingLightControl
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainArcadeControl
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainModeControl
import org.usfirst.frc5293.impl.systems.drivetrain.DrivetrainTankControl
import org.usfirst.frc5293.impl.systems.drivetrain.DualDrivetrainInput
import org.usfirst.frc5293.impl.systems.shooter.kicker.ShooterKickerControl

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

object TeleopControls : LazyControlGroup(), Logging {

    private val joystick1 by lazyByRequest { Joystick(0) }
    private val joystick2 by lazyByRequest { Joystick(1) }
    private val joystick3 by lazyByRequest { Joystick(2) }

    object drivetrain {

        val input by TeleopControls.lazyByRequest {
            DualDrivetrainInput(
                    leftJoystick = joystick1,
                    rightJoystick = joystick2)
        }

        val tankControl by TeleopControls.lazyByRequest {
            DrivetrainTankControl(input)
        }

        val arcadeControl by TeleopControls.lazyByRequest {
            DrivetrainArcadeControl(input)
        }

        val modeButton by TeleopControls.lazyByRequest {
            joystick1.button(3)
        }

        val modeControl by TeleopControls.lazyByRequest {
            DrivetrainModeControl(
                    arcadeCommand = arcadeControl,
                    tankCommand = tankControl,
                    button = modeButton,
                    drive = Subsystems.drivetrain
            )
        }
    }

    init { subgroups.add(drivetrain) }

    object camera {

        object mount {

            val joystick by TeleopControls.lazyByRequest {
                NullJoystick
            }

            val originButton by TeleopControls.lazyByRequest {
                joystick.button(4) // TODO: Can't remember which button it is...
            }

            val input by TeleopControls.lazyByRequest {
                CameraMountInput(
                        x = { joystick.twist },
                        y = { joystick.y},
                        originButton = originButton)
            }

            val control by TeleopControls.lazyByRequest {
                CameraMountControl(input, Subsystems.camera.mount)
            }
        }

        init { TeleopControls.subgroups.add(mount) }

        object ringLight {

            val joystick by TeleopControls.lazyByRequest {
                joystick3
            }

            val input by TeleopControls.lazyByRequest {
                joystick.button(3)
            }

            val control by TeleopControls.lazyByRequest {
                CameraRingLightControl(input, Subsystems.camera.ringLight)
            }
        }

        init { TeleopControls.subgroups.add(ringLight) }
    }

    init { TeleopControls.subgroups.add(camera) }

    object shooter {

        object wheels {

            val joystick by TeleopControls.lazyByRequest {
                joystick3
            }

            val input by TeleopControls.lazyByRequest {
                SingleAxisButtonInput(
                        positiveButton = joystick.button(6),
                        negativeButton = joystick.button(4))
            }

            val power = SingleAxisPowerSettings(
                    positivePower = 1.0,
                    negativePower = -0.3
            )

            val control by TeleopControls.lazyByRequest {
                SingleAxisButtonControl(input, power, Subsystems.shooter.wheels)
            }
        }

        init { TeleopControls.subgroups.add(wheels) }

        object kicker {

            val joystick by TeleopControls.lazyByRequest {
                joystick3
            }

            val button by TeleopControls.lazyByRequest {
                joystick.button(1)
            }

            val control by TeleopControls.lazyByRequest {
                ShooterKickerControl(button, Subsystems.shooter.kicker)
            }
        }

        init { TeleopControls.subgroups.add(kicker) }

        object lifter {

            val input by TeleopControls.lazyByRequest {
                { joystick3.y }
            }

            val control by TeleopControls.lazyByRequest {
                DeadzoneMotorSubsystemControl(input, Subsystems.shooter.lifter)
            }
        }

        init { TeleopControls.subgroups.add(lifter) }
    }

    init { TeleopControls.subgroups.add(shooter) }

    object lifter {

        object winchMotor {
            val joystick by TeleopControls.lazyByRequest {
                joystick3
            }

            val input by TeleopControls.lazyByRequest {
                SingleAxisButtonInput(
                        positiveButton = joystick.button(9),
                        negativeButton = joystick.button(11)
                )
            }

            val power by TeleopControls.lazyByRequest {
                SingleAxisPowerSettings(
                        positivePower = -1.0,
                        negativePower = 1.0
                )
            }

            val control by TeleopControls.lazyByRequest {
                SingleAxisButtonControl(input, power, Subsystems.winchMotor)
            }
        }

        init { TeleopControls.subgroups.add(winchMotor) }

        object windowMotor {

            val joystick by TeleopControls.lazyByRequest {
                joystick2
            }

            val controlInput by TeleopControls.lazyByRequest {
                {
                    val raw = joystick.x
                    val power = if (Math.abs(raw) > 0.10) raw else 0.0
                    val scale = Prefs.root.winchSpeedScale.get()
                    power * scale
                }
            }

            val childControl by TeleopControls.lazyByRequest {
                RawMotorSubsystemControl(controlInput, Subsystems.windowMotor)
            }

            val button by TeleopControls.lazyByRequest {
                joystick.button(1)
            }

            val control by TeleopControls.lazyByRequest {
                HookedStreamControl({ button.get() }, childControl)
            }
        }

        init { TeleopControls.subgroups.add(windowMotor) }
    }

    init { TeleopControls.subgroups.add(lifter) }

    override val controls: List<*> by lazy {
        listOf(drivetrain.tankControl,
                drivetrain.arcadeControl,
                drivetrain.modeControl,
                shooter.wheels.control,
                shooter.kicker.control,
                shooter.lifter.control,
                camera.ringLight.control,
                lifter.winchMotor.control,
                lifter.windowMotor.childControl,
                lifter.windowMotor.control)
    }
}

abstract class LazyControlGroup : LazyGroup() {

    abstract val controls: List<*>

    override fun init() {
        super.init()
        initCommands()
    }

    private fun initCommands() {
        TeleopControls.controls.forEach {
            if (it is Initializable) {
                it.init()
            }

            if (it is Command) {
                Scheduler.getInstance().add(it)
            }
        }
    }

    fun startAll() {
        TeleopControls.controls.forEach {
            if (it is Command) {
                it.start()
            }
        }

        TeleopControls.logger.info("Started ${TeleopControls.controls.count()} commands")
    }

    fun cancelAll() {
        TeleopControls.controls.forEach {
            when (it) {
                is Command ->
                    it.cancel()
            }
        }

        TeleopControls.logger.info("Canceled ${TeleopControls.controls.count()} commands")
    }
}

fun Joystick.button(buttonNumber: Int) = JoystickButton(this, buttonNumber)

