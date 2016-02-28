package org.usfirst.frc5293.commands.teleop.control

import org.usfirst.frc5293.Inputs
import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.EmptyCommand

class DrivetrainControl : EmptyCommand() {

    init {
        requires(Subsystems.drivetrain)
    }

    override fun execute() {
        Subsystems.drivetrain.driveArcade(
                power = Inputs.drivetrain.powerJoystick.y,
                rotation = Inputs.drivetrain.rotationJoystick.twist
        )
    }

//    private fun drive(state: TankDrivingState) {
//        Subsystems.drivetrain.driveTank(state.left, state.right)
//    }

    override fun end() {
        Subsystems.drivetrain.stop()
    }
}
