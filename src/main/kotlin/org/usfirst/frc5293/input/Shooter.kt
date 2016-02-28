package org.usfirst.frc5293.input

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc5293.Prefs
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.SubsystemCommand
//
//class Shooter(val inButton: JoystickButton, val outButton: JoystickButton) {
//
//    private enum class Direction {
//        NONE,
//        IN,
//        OUT
//    }
//
//    private var currentDirection = Direction.NONE
//
//    private val power = Prefs.root.shooterWheelSpeed.get()
//
//    init {
//        inButton.whileHeld(object : SubsystemCommand(Subsystems.shooter) {
//            init {
//                if (currentDirection != Direction.NONE) {
//                    done()
//                }
//            }
//
//            override fun action() {
//                currentDirection = Direction.IN
//                Subsystems.shooter.power = power
//            }
//
//            override fun end() {
//                currentDirection = Direction.NONE
//                Subsystems.shooter.stop()
//            }
//        })
//
//        outButton.whileHeld(object : SubsystemCommand(Subsystems.shooter) {
//            init {
//                if (currentDirection != Direction.NONE) {
//                    done()
//                }
//            }
//
//            override fun action() {
//                currentDirection = Direction.OUT
//                Subsystems.shooter.power = -power
//            }
//
//            override fun end() {
//                currentDirection = Direction.NONE
//                Subsystems.shooter.stop()
//            }
//        })
//    }
//}

class Shooter(val joystick: Joystick)