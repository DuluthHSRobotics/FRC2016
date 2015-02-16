package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.prefs.Drivetrain;

public class MecanumDriveControl extends ContinuousCommand {

    private final MecanumDrive input;
    private final Drivetrain prefs = Prefs.getDrivetrain();

    public MecanumDriveControl() {
        requires(Subsystems.getDrivetrain());
        input = Input.getMecanumDrive();
    }

    private static class DrivingState {
        public double x;
        public double y;
        public double r;
    }

    private DrivingState getState() {
        DrivingState state = new DrivingState();

        state.x = input.getStrafeJoystick().getX();
        state.y = input.getStrafeJoystick().getY();
        state.r = input.getRotationJoystick().getTwist();

        return state;
    }

    private DrivingState applySystemDisabling(DrivingState state) {
        if (!prefs.isSystemEnabled().get()) {
            state.x = 0;
            state.y = 0;
            state.r = 0;
        }

        return state;
    }

    private DrivingState applyAxisDisabling(DrivingState state) {
        if (!prefs.isXEnabled().get()) {
            state.x = 0;
        }

        if (!prefs.isYEnabled().get()) {
            state.y = 0;
        }

        if (!prefs.isRotationEnabled().get()) {
            state.r = 0;
        }

        return state;
    }

    private DrivingState applySensitiveRotation(DrivingState state) {
        if (prefs.isSensitiveRotationEnabled().get() && input.getSensitiveRotationButton().get()) {
            state.r *= prefs.getSensitiveScaleRotation().get();
        }

        return state;
    }

    private DrivingState applyAxisLocking(DrivingState state) {
        if (prefs.isAxisLockingEnabled().get()) {
            if (input.getDriveXAxisButton().get()) {
                state.y = 0;
            } else if (input.getDriveYAxisButton().get()) {
                state.x = 0;
            }
        }

        return state;
    }

    private DrivingState applyScaling(DrivingState state) {
        state.x *= prefs.getScaleX().get();
        state.y *= prefs.getScaleY().get();
        state.r *= prefs.getScaleRotation().get();
        return state;
    }

    private DrivingState applyInversions(DrivingState state) {
        state.x *= -1;
        state.y *=  1;
        state.r *= -1;
        return state;
    }

    @Override
    protected void execute() {
        DrivingState state = getState();

        applySystemDisabling(state);
        applyAxisDisabling(state);
        applySensitiveRotation(state);
        applyAxisLocking(state);
        applyInversions(state);
        applyScaling(state);

        drive(state);
    }

    private void drive(DrivingState state) {
        Subsystems.getDrivetrain().drive(state.x, state.y, state.r);
    }

    @Override
    protected void end() {
    	Subsystems.getDrivetrain().stop();
    }
}
