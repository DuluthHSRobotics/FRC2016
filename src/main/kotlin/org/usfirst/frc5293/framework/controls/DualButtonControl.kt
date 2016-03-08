package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.subsystems.MotorSubsystem
import org.usfirst.frc5293.impl.Devices

class DualButtonControl<TSubsystem>(
        val inButton: JoystickButton,
        val outButton: JoystickButton,
        val power: () -> Double,
        val subsystem: TSubsystem)
            where TSubsystem : Subsystem,
                  TSubsystem : MotorSubsystem {

    private enum class Direction {
        NONE,
        IN,
        OUT
    }

    private var currentDirection = Direction.NONE

    init {
        inButton.whileHeld(object : SubsystemCommand(subsystem) {
            init {
                if (currentDirection != Direction.NONE) {
                    done()
                }
            }

            override fun action() {
                currentDirection = Direction.IN
                subsystem.power = power()
            }

            override fun end() {
                currentDirection = Direction.NONE
                subsystem.stop()
            }
        })

        outButton.whileHeld(object : SubsystemCommand(subsystem) {
            init {
                if (currentDirection != Direction.NONE) {
                    done()
                }
            }

            override fun action() {
                currentDirection = Direction.OUT
                subsystem.power = -power()
            }

            override fun end() {
                currentDirection = Direction.NONE
                subsystem.stop()
            }
        })
    }
}