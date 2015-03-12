package org.usfirst.frc5293.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public abstract class TimedCommand extends Command {

    private final double seconds;
    private Timer timer;

    protected TimedCommand(double seconds) {
        super();
        this.seconds = seconds;
    }

    @Override
    protected void initialize() {
        timer = new Timer();
        timer.start();
    }

    @Override
    protected boolean isFinished() {
        return timer.hasPeriodPassed(seconds);
    }

    @Override
    protected void end() {
        timer.stop();
    }

    @Override
    protected void interrupted() {
        timer.start();
    }
}
