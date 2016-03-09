package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.subsystems.SpeedControllerSubsystem

class SingleAxisButtonInput(
        val positiveButton: Button,
        val negativeButton: Button)


data class SingleAxisPowerSettings(val positivePower: Double, val negativePower: Double)

class SingleAxisButtonControl<TSubsystem>(
        val input: SingleAxisButtonInput,
        val power: SingleAxisPowerSettings,
        val subsystem: TSubsystem)
            where TSubsystem : Subsystem,
                  TSubsystem : SpeedControllerSubsystem {

    init {
        // Since each command will require the subsystem and is interruptible, when the other button
        // is pressed:
        //  (1) the current command will be interrupted and,
        //  (2) the pressed button command becomes active.
        //
        // This saves you from having to implement basically a state-machine.
        //

        object : PushDownButtonControl(input.positiveButton) {
            override val subsystems = listOf(subsystem)

            override fun onPressed() {
                subsystem.power = power.positivePower
            }

            override fun onReleased() {
                subsystem.stop()
            }
        }.init()

        object : PushDownButtonControl(input.negativeButton) {
            override val subsystems = listOf(subsystem)

            override fun onPressed() {
                subsystem.power = power.negativePower
            }

            override fun onReleased() {
                subsystem.stop()
            }
        }.init()
    }
}