package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.MecanumDriveEngine;

public class MecanumDriveControl extends ContinuousCommand {

    private MecanumDriveEngine engine = new MecanumDriveEngine();

    public MecanumDriveControl() {
        requires(Subsystems.getDrivetrain());
    }

    @Override
    protected void execute() {
        drive(engine.getResult());
    }

    private void drive(DrivingState state) {
        Subsystems.getDrivetrain().drive(state.x, state.y, state.r);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
