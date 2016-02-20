package org.usfirst.frc5293.commands.util;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.List;

public abstract class ActionCommand extends EmptyCommand {

    private boolean isFinished = false;

    protected ActionCommand() {
    }

    protected ActionCommand(Subsystem subsystem) {
        requires(subsystem);
    }

    protected ActionCommand(List<Subsystem> subsystems) {
        for (Subsystem subsystem : subsystems) {
            requires(subsystem);
        }
    }

    protected abstract void action();

    @Override
    protected void execute() {
        action();
        isFinished = true;
    }

    @Override
    protected boolean isFinished() {
        return isFinished;
    }
}
