package org.usfirst.frc5293.commands.util;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.List;

public abstract class ActionCommandGroup extends EmptyCommandGroup {

    protected boolean isFinished = false;

    protected ActionCommandGroup() {
    }

    protected ActionCommandGroup(Subsystem subsystem) {
        requires(subsystem);
    }

    protected ActionCommandGroup(List<Subsystem> subsystems) {
        for (Subsystem subsystem : subsystems) {
            requires(subsystem);
        }
    }

    @Override
    protected boolean isFinished() {
        return isFinished;
    }
}
