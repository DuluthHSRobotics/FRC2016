package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.translations.util.ArcadeDrivingState;
import org.usfirst.frc5293.translations.driving.JoystickDriveEngine;
import org.usfirst.frc5293.translations.util.TankDrivingState;

public class DrivetrainControl extends ContinuousCommand {

    public DrivetrainControl() {
        requires(Subsystems.getDrivetrain());
    }

    @Override
    protected void execute() {
        drive(JoystickDriveEngine.getInstance().getResult());
    }

    private void drive(TankDrivingState state) {
        Subsystems.getDrivetrain().driveTank(state.left, state.right);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
