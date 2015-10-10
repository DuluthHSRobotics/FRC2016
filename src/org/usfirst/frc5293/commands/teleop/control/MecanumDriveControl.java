package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.driving.JoystickDriveEngine;

public class MecanumDriveControl extends ContinuousCommand {

    public MecanumDriveControl() {
        requires(Subsystems.getDrivetrain());
    }

    @Override
    protected void execute() {
        drive(JoystickDriveEngine.getInstance().getResult());
    }

    private void drive(DrivingState state) {
        Subsystems.getDrivetrain().drive(state.x, state.y, state.r);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
