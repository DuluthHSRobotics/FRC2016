package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem

class SingleAxisButtonInput(
        val positiveButton: Button,
        val negativeButton: Button)


data class SingleAxisPowerSettings(val positivePower: Double, val negativePower: Double)

class SingleAxisButtonControl<TSubsystem>(
        val input: SingleAxisButtonInput,
        val power: SingleAxisPowerSettings,
        val subsystem: TSubsystem)
            where TSubsystem : Subsystem,
                  TSubsystem : MotorSubsystem {

    init {
        // Since each command will require the subsystem and is interruptible, when the other button
        // is pressed:
        //  (1) the current command will be interrupted and,
        //  (2) the pressed button command becomes active.
        //
        // This saves you from having to implement basically a state-machine.
        //

        input.positiveButton.whileHeld(object : SubsystemCommand(subsystem) {
            override fun isInterruptible() = true

            override fun action() {
                subsystem.power = power.positivePower
            }

            override fun end() {
                subsystem.stop()
            }
        })

        input.negativeButton.whileHeld(object : SubsystemCommand(subsystem) {
            override fun isInterruptible() = true

            override fun action() {
                subsystem.power = power.negativePower
            }

            override fun end() {
                subsystem.stop()
            }
        })
    }
}