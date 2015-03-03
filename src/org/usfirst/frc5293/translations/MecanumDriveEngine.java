package org.usfirst.frc5293.translations;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.TranslationEngine;
import org.usfirst.frc5293.util.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MecanumDriveEngine extends TranslationEngine<DrivingState> {
    private static final double DEADZONE = 0.1;

    private final MecanumDrive input;
    private final Drivetrain prefs = Prefs.getDrivetrain();

    public MecanumDriveEngine() {
        input = Input.getMecanumDrive();
    }

    @Override
    protected DrivingState getInitial() {
        DrivingState state = new DrivingState();

        state.x = input.getStrafeJoystick().getX();
        state.y = input.getStrafeJoystick().getY();
        state.r = input.getRotationJoystick().getTwist();

        return state;
    }

    @Override
    protected List<Function<DrivingState, DrivingState>> getOperations() {
        List<Function<DrivingState, DrivingState>> ops = new ArrayList<>();

        ops.add(this::applySystemDisabling);
        ops.add(this::applyAxisDisabling);
        ops.add(this::applySensitiveRotation);
        ops.add(this::applyAxisLocking);
        ops.add(this::applyInversions);
        ops.add(this::applyQuadScaling);

        return ops;
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

    private DrivingState applyQuadScaling(DrivingState state) {
        state.apply(x -> MathUtil.quadDeadzone(x, DEADZONE));
        return state;
    }

    private DrivingState applyInversions(DrivingState state) {
        state.x *= -1;
        state.y *=  1;
        state.r *= -1;
        return state;
    }
}
