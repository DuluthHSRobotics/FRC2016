package org.usfirst.frc5293.framework.controls

import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc5293.framework.commands.SubsystemCommand
import org.usfirst.frc5293.framework.subsystems.Direction
import org.usfirst.frc5293.framework.subsystems.DirectionalSubsystem

class UpDownInput<TSubsystem>(upButton: JoystickButton, downButton: JoystickButton, val lift: TSubsystem)
    where TSubsystem : Subsystem,
          TSubsystem : DirectionalSubsystem {

    init {
        upButton.whileHeld(object : SubsystemCommand(lift) {
            init {
                if (lift.direction == Direction.DOWN) {
                    done()
                }
            }

            override fun action() {
                lift.up()
            }

            override fun end() {
               lift.stop()
            }
        })

        downButton.whileHeld(object : SubsystemCommand(lift) {
            init {
                if (lift.direction != Direction.NONE) {
                    done()
                }
            }

            override fun action() {
                lift.down()
            }

            override fun end() {
                lift.stop()
            }
        })
    }
}