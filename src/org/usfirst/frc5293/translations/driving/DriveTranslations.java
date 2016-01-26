package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.prefs.DriveScalingPref;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.util.MathUtil;

public class DriveTranslations {

    private static DriveTranslations instance;

    public static DriveTranslations getInstance() {
        if (instance == null) {
            instance = new DriveTranslations();
        }

        return instance;
    }

    //

    private final MecanumDrive input;
    private final Drivetrain prefs = Prefs.getDrivetrain();

    public DriveTranslations() {
        input = Input.getMecanumDrive();
    }

    public DrivingState applySystemDisabling(DrivingState state) {
        if (!prefs.isSystemEnabled().get()) {
            state.x = 0;
            state.y = 0;
            state.r = 0;
        }

        return state;
    }

    public DrivingState applyAxisDisabling(DrivingState state) {
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

    public DrivingState applyDriveScalingPref(DrivingState state, DriveScalingPref pref) {
        if (!pref.isEnabled().get()) {
            return state;
        }

        state.x *= pref.getX().get();
        state.y *= pref.getY().get();
        state.r *= pref.getRotation().get();

        return state;
    }

    public DrivingState applyDefaultScaling(DrivingState state) {
        return applyDriveScalingPref(state, prefs.getDefaultScaling());
    }

    public DrivingState applySensitiveScaling(DrivingState state) {
        if (!(Input.getSensitivityModeButton().get())) {
            return state;
        }

        return applyDriveScalingPref(state, prefs.getSensitiveScaling());
    }

    public DrivingState applyAxisLocking(DrivingState state) {
        if (prefs.isAxisLockingEnabled().get()) {
            if (input.getDriveXAxisButton().get()) {
                state.y = 0;
            } else if (input.getDriveYAxisButton().get()) {
                state.x = 0;
            }
        }

        return state;
    }

    public DrivingState applyQuadScaling(DrivingState state) {
        if (!prefs.isScalingFunctionsEnabled().get()) {
            return state;
        }

        double deadzone = prefs.getDeadzone().get();
        state.x = MathUtil.quadEaseWithDeadzone(state.x, deadzone);
        state.y = MathUtil.quadEaseWithDeadzone(state.y, deadzone);
        state.r = MathUtil.powerEaseWithDeadzone(state.r, 3, deadzone);
        return state;
    }

    public DrivingState applyInversions(DrivingState state) {
        state.x *=  1;
        state.y *=  1;
        state.r *= -1;
        return state;
    }
}
