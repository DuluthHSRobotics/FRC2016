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

    private final DriveScalingPref defaultScaling = new DriveScalingPref("default");
    { all.addAll(defaultScaling.getAll()); }

    private final DriveScalingPref sensitiveScaling = new DriveScalingPref("sensitive");
    { all.addAll(sensitiveScaling.getAll()); }

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

    public DriveScalingPref getDefaultScaling() {
        return defaultScaling;
    }

    public DriveScalingPref getSensitiveScaling() {
        return sensitiveScaling;
    }

    public BooleanPref isAxisLockingEnabled() {
        return isAxisLockingEnabled;
    }

    public DoublePref getDeadzone() {
        return deadzone;
    }

    public BooleanPref isScalingFunctionsEnabled() { return isScalingFunctionsEnabled; }
}
