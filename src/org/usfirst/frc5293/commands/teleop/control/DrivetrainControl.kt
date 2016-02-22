package org.usfirst.frc5293.commands.teleop.control

import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.EmptyCommand
import org.usfirst.frc5293.translations.driving.JoystickDriveEngine
import org.usfirst.frc5293.translations.util.TankDrivingState

class DrivetrainControl : EmptyCommand() {

    init {
        requires(Subsystems.drivetrain)
    }

    override fun execute() {
        drive(JoystickDriveEngine.result)
    }

    private fun drive(state: TankDrivingState) {
        Subsystems.drivetrain.driveTank(state.left, state.right)
    }

    override fun end() {
        Subsystems.drivetrain.stop()
    }
}
