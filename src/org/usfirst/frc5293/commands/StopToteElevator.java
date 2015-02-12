package org.usfirst.frc5293.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5293.Robot;

public class StopToteElevator extends Command {
    @Override
    protected void initialize() {
        requires(Robot.toteElevator);
    }

    @Override
    protected void execute() {
        Robot.toteElevator.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
