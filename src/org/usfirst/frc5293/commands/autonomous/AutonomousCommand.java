package org.usfirst.frc5293.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5293.Subsystems;

public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
        addSequential(new TimedCommand(2.0) {
            @Override
            protected void execute() {
                Subsystems.getDrivetrain().drive(0.0, 0.7, 0);
            }

            @Override
            protected void end() {
                super.end();
                Subsystems.getDrivetrain().stop();
            }
        });
    }
}
