package org.usfirst.frc5293.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5293.Robot;

public class ReleaseTote extends Command {

    // TODO: Might need to be adjusted
    public static final int TIMEOUT_SECONDS = 6;

    public ReleaseTote() {
        requires(Robot.toteElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(TIMEOUT_SECONDS);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.toteElevator.getLowerSwitch().get()) {
    		Robot.toteElevator.lowerTotes();
    	}
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
