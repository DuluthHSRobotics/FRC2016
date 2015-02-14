package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.commands.util.EmptyCommand;
import org.usfirst.frc5293.commands.util.LimitFunction;
import org.usfirst.frc5293.util.MathUtil;
import org.usfirst.frc5293.util.TimedEaseIn;

public class ToteElevatorControl extends ContinuousCommand {

    private static enum ControlState {
        NONE,
        RAISE,
        LOWER
    }

    private static final double MOTOR_MAX = 1.0;
    private static final double MOTOR_MIN = 0.0;

    public ToteElevatorControl() {
        requires(Subsystems.getToteElevator());
    }

    @Override
    protected void execute() {
        ControlState state = getControlState();

        switch (state) {
            case NONE:
                Subsystems.getToteElevator().stop();
                return;

            case RAISE:
                runWithNextValue(Subsystems.getToteElevator()::raise);
                break;

            case LOWER:
                runWithNextValue(Subsystems.getToteElevator()::lower);
                break;
        }
    }

    @Override
    protected void end() {
        Subsystems.getToteElevator().stop();
    }

    private void runWithNextValue(LimitFunction func) {
        double clamped = getNextValue();
        func.run(clamped);
    }

    private double getNextValue() {
        return MOTOR_MAX;
    }

    private ControlState getControlState() {
        boolean isUp = Input.getToteElevator().getUpButton().get();
        boolean isDown = Input.getToteElevator().getDownButton().get();

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
