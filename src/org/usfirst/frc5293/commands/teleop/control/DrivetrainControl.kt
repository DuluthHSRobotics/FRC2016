package org.usfirst.frc5293.commands.teleop.control

import org.usfirst.frc5293.Subsystems
import org.usfirst.frc5293.commands.util.ContinuousCommand
import org.usfirst.frc5293.translations.driving.JoystickDriveEngine
import org.usfirst.frc5293.translations.util.TankDrivingState

class DrivetrainControl : ContinuousCommand() {

    init {
        requires(Subsystems.drivetrain)
    }

    override fun execute() {
        drive(JoystickDriveEngine.getInstance().result)
    }

    private fun drive(state: TankDrivingState) {
        Subsystems.drivetrain.driveTank(state.left, state.right)
    }

    override fun end() {
        Subsystems.drivetrain.stop()
    }
}
