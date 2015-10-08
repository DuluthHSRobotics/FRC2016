package org.usfirst.frc5293.translations.joystick;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine;
import org.usfirst.frc5293.util.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MecanumDriveEngine extends StreamingTranslationEngine<DrivingState> {

    private static MecanumDriveEngine instance;

    public static MecanumDriveEngine getInstance() {
        if (instance == null) {
            instance = new MecanumDriveEngine();
        }
        return instance;
    }

    //

    private final MecanumDrive input;
    private final Drivetrain prefs = Prefs.getDrivetrain();

    private MecanumDriveEngine() {
        input = Input.getMecanumDrive();
    }

    @Override
    protected DrivingState getInitial() {
        DrivingState state = new DrivingState();

        state.x = input.getStrafeJoystick().getX();
        state.y = input.getStrafeJoystick().getY();
        state.r = input.getRotationJoystick().getTwist() * 0.3; // TODO: HACK!!!

        return state;
    }

    @Override
    protected List<Function<DrivingState, DrivingState>> getOperations() {
        List<Function<DrivingState, DrivingState>> ops = new ArrayList<>();

        ops.add(this::applySystemDisabling);
        ops.add(this::applyAxisDisabling);
        ops.add(this::applyAxisLocking);
        ops.add(this::applyQuadScaling);
        ops.add(this::applySensitiveScaling);
        ops.add(this::applyInversions);

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

    private DrivingState applySensitiveScaling(DrivingState state) {
        if (!Prefs.getRoot().isSensitiveScalingEnabled().get()
                || !Input.getSensitivityModeButton().get()) {
            return state;
        }

        state.x *= prefs.getScaleX().get();
        state.y *= prefs.getScaleY().get();
        state.r *= prefs.getScaleRotation().get();

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
        if (!prefs.isScalingFunctionsEnabled().get()) {
            return state;
        }

        double deadzone = prefs.getDeadzone().get();
        state.x = MathUtil.quadEaseWithDeadzone(state.x, deadzone);
        state.y = MathUtil.quadEaseWithDeadzone(state.y, deadzone);
        state.r = MathUtil.powerEaseWithDeadzone(state.r, 3, deadzone);
        return state;
    }

    private DrivingState applyInversions(DrivingState state) {
        state.x *=  1;
        state.y *=  1;
        state.r *= -1;
        return state;
    }
}
