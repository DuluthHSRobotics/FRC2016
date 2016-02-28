package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.SubsystemCommand

class UpDownInput(upButton: JoystickButton, downButton: JoystickButton, val lift: LiftSubsystem) {

    init {
        upButton.whenActive(object : SubsystemCommand(Subsystems.lift) {
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

        downButton.whenActive(object : SubsystemCommand(Subsystems.lift) {
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


class ManualInput(val joystick: Joystick)