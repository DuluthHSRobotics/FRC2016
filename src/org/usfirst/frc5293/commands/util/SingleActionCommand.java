package org.usfirst.frc5293.commands.util;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class SingleActionCommand extends EmptyCommand {

    private final Runnable action;
    private boolean isFinished = false;

    protected SingleActionCommand(Runnable action, Subsystem... subsystems) {
        this.action = action;

        for (Subsystem subsystem : subsystems) {
            requires(subsystem);
        }
    }

    @Override
    protected void execute() {
        action.run();
        isFinished = true;
    }

    @Override
    protected boolean isFinished() {
        return isFinished;
    }
}
