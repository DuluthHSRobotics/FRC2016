package org.usfirst.frc5293.groups.lift

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.SubsystemCommand
//
//class Input(upButton: JoystickButton, downButton: JoystickButton) {
//
//    private enum class Direction {
//        NONE,
//        UP,
//        DOWN
//    }
//
//    private var currentDirection = Direction.NONE
//
//    init {
//        upButton.whenActive(object : SubsystemCommand(Subsystems.lift) {
//            init {
//                if (currentDirection != Direction.NONE) {
//                    done()
//                }
//            }
//
//            override fun action() {
//                currentDirection = Direction.UP
//                Subsystems.lift.up()
//            }
//
//            override fun end() {
//                currentDirection = Direction.NONE
//                Subsystems.lift.stop()
//            }
//        })
//
//        downButton.whenActive(object : SubsystemCommand(Subsystems.lift) {
//            init {
//                if (currentDirection != Direction.NONE) {
//                    done()
//                }
//            }
//
//            override fun action() {
//                currentDirection = Direction.DOWN
//                Subsystems.lift.down()
//            }
//
//            override fun end() {
//                currentDirection = Direction.NONE
//                Subsystems.lift.stop()
//            }
//        })
//    }
//}


class Lift(val joystick: Joystick)