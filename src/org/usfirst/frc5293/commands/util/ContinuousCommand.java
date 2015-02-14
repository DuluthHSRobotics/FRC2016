package org.usfirst.frc5293.commands.util;

/**
 * An empty command that will never finish
 */
public class ContinuousCommand extends EmptyCommand {
    @Override
    protected boolean isFinished() {
        return false;
    }
}
