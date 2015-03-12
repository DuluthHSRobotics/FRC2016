package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.DoublePref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public class Drivetrain implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();

    private final BooleanPref isSystemEnabled = new BooleanPref(
            "drivetrain:is_system_enabled",
            true
    ); { all.add(isSystemEnabled); }

    private final BooleanPref isXEnabled = new BooleanPref(
            "drivetrain:is_x_enabled",
            true
    ); { all.add(isXEnabled); }

    private final BooleanPref isYEnabled = new BooleanPref(
            "drivetrain:is_y_enabled",
            true
    ); { all.add(isYEnabled); }

    private final BooleanPref isRotationEnabled = new BooleanPref(
            "drivetrain:is_rotation_enabled",
            true
    ); { all.add(isRotationEnabled); }

    private final DoublePref scaleX = new DoublePref(
            "drivetrain:scale_x",
            1.0
    ); { all.add(scaleX); }

    private final DoublePref scaleY = new DoublePref(
            "drivetrain:scale_y",
            1.0
    ); { all.add(scaleY); }

    private final DoublePref scaleRotation = new DoublePref(
            "drivetrain:scale_rotation",
            1.0
    ); { all.add(scaleRotation); }

    private final DoublePref sensitiveScaleRotation = new DoublePref(
            "drivetrain:sensitive_scale_rotation",
            0.2
    ); { all.add(sensitiveScaleRotation); }

    private final BooleanPref isAxisLockingEnabled = new BooleanPref(
            "drivetrain:is_axis_locking_enabled",
            true
    ); { all.add(isAxisLockingEnabled);}

    private final DoublePref deadzone = new DoublePref(
            "drivetrain:deadzone",
            0.05
    ); { all.add(deadzone); }

    private final BooleanPref isScalingFunctionsEnabled = new BooleanPref(
            "drivetrain:is_scaling_function_enabled",
            true
    ); { all.add(isScalingFunctionsEnabled); }

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }

    public BooleanPref isSystemEnabled() {
        return isSystemEnabled;
    }

    public BooleanPref isXEnabled() {
        return isXEnabled;
    }

    public BooleanPref isYEnabled() {
        return isYEnabled;
    }

    public BooleanPref isRotationEnabled() {
        return isRotationEnabled;
    }

    public DoublePref getScaleX() {
        return scaleX;
    }

    public DoublePref getScaleY() {
        return scaleY;
    }

    public DoublePref getScaleRotation() {
        return scaleRotation;
    }

    public BooleanPref isAxisLockingEnabled() {
        return isAxisLockingEnabled;
    }

    public DoublePref getDeadzone() {
        return deadzone;
    }

    public BooleanPref isScalingFunctionsEnabled() { return isScalingFunctionsEnabled; }
}
