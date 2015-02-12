// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Robot;
import org.usfirst.frc5293.commands.util.EmptyCommand;
import org.usfirst.frc5293.commands.util.LimitFunction;
import org.usfirst.frc5293.commands.util.TimedEaseIn;
import org.usfirst.frc5293.util.Prefs;
import org.usfirst.frc5293.util.Util;

public class CollectTote extends EmptyCommand {

    private static enum ControlState {
        NONE,
        RAISE,
        LOWER
    }

    private static final double MOTOR_MAX = 1.0;
    private static final double MOTOR_MIN = 0.0;

    private boolean isRunning;
    private TimedEaseIn easeIn;

    public CollectTote() {
        requires(Robot.toteElevator);

        this.isRunning = false;
        this.easeIn = null;
    }

    @Override
    protected void execute() {
        ControlState state = getControlState();

        switch (state) {
            case NONE:
                Robot.toteElevator.stop();
                return;

            case RAISE:
                updateWithNextValue(Robot.toteElevator::raise);
                break;

            case LOWER:
                updateWithNextValue(Robot.toteElevator::lower);
                break;
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    private void updateWithNextValue(LimitFunction func) {
        if (!isRunning) {
            easeIn = new TimedEaseIn(
                    MOTOR_MIN,
                    Prefs.EaseIn.easeInChange.get(),
                    Prefs.EaseIn.easeInDuration.get());
            
            isRunning = true;
        }

        double clamped = getNextValue();
        func.run(clamped);
    }

    private double getNextValue() {
        double value = easeIn.loop();
        return Util.clampMax(value, MOTOR_MAX);
    }

    private ControlState getControlState() {
        boolean isUp = Robot.oi.getToteElevator().getUpButton().get();
        boolean isDown = Robot.oi.getToteElevator().getDownButton().get();

        if (!isUp && !isDown) {
            return ControlState.NONE;
        }

        if (isUp) {
            return ControlState.RAISE;
        } else {
            return ControlState.LOWER;
        }
    }
}
