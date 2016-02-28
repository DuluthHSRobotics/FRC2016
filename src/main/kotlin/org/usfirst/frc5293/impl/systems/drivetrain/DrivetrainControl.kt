package org.usfirst.frc5293.impl.systems.drivetrain

import org.usfirst.frc5293.framework.commands.EmptyCommand
import org.usfirst.frc5293.impl.Inputs
import org.usfirst.frc5293.impl.Subsystems

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
