package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.EmptyCommand;
import org.usfirst.frc5293.commands.util.LimitFunction;
import org.usfirst.frc5293.util.Prefs;
import org.usfirst.frc5293.util.TimedEaseIn;
import org.usfirst.frc5293.util.MathUtil;

public class ToteElevatorControl extends EmptyCommand {

    private static enum ControlState {
        NONE,
        RAISE,
        LOWER
    }

    private static final double MOTOR_MAX = 1.0;
    private static final double MOTOR_MIN = 0.0;

    private boolean isRunning;
    private TimedEaseIn easeIn;

    public ToteElevatorControl() {
        requires(Subsystems.getToteElevator());
        this.isRunning = false;
        this.easeIn = null;
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
    protected boolean isFinished() {
        return false;
    }

    private void runWithNextValue(LimitFunction func) {
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
        if (!Prefs.EaseIn.isEnabled.get()) {
            return MOTOR_MAX;
        }

        double value = easeIn.loop();
        return MathUtil.clampMax(value, MOTOR_MAX);
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
