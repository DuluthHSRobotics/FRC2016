package org.usfirst.frc5293.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.TimedCommand;
import org.usfirst.frc5293.translations.autonomous.MecanumDriveEngine;
import org.usfirst.frc5293.translations.util.DrivingState;

public class AutonomousCommandGroup extends CommandGroup {

    private static final double SECONDS = 2.0;
    private static final MecanumDriveEngine engine = MecanumDriveEngine.getInstance();
    private static final DrivingState movement = new DrivingState(0.0, 0.7, 0.0);

    public AutonomousCommandGroup() {
        addSequential(new TimedCommand(SECONDS) {
            @Override
            protected void execute() {
                final DrivingState result = engine.getResult(movement);
                drive(result);
            }

            @Override
            protected void end() {
                super.end();
                stop();
            }
        });
    }

    private void drive(DrivingState state) {
        Subsystems.getDrivetrain().drive(state.x, state.y, state.r);
    }

    private void stop() {
        Subsystems.getDrivetrain().stop();
    }
}
