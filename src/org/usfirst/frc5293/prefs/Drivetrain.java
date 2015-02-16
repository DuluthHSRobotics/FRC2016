package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.DoublePref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public class Drivetrain implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();

    private final BooleanPref isXEnabled = new BooleanPref(
            "drivetrain:is_x_enabled",
            true
    );

    private final BooleanPref isYEnabled = new BooleanPref(
            "drivetrain:is_y_enabled",
            true
    );

    private final BooleanPref isRotationEnabled = new BooleanPref(
            "drivetrain:is_rotation_enabled",
            true
    );


    private final DoublePref scaleX = new DoublePref(
            "drivetrain:scale_x",
            1.0
    );

    private final DoublePref scaleY = new DoublePref(
            "drivetrain:scale_y",
            1.0
    );

    private final DoublePref scaleRotation = new DoublePref(
            "drivetrain:scale_rotation",
            1.0
    );

    private final BooleanPref isSensitiveRotationEnabled = new BooleanPref(
            "drivetrain:is_sensitive_rotation_enabled",
            true
    );

    private final DoublePref sensitiveScaleRotation = new DoublePref(
            "drivetrain:sensitive_scale_rotation",
            0.2
    );

    public Drivetrain() {
        all.add(isXEnabled);
        all.add(isYEnabled);
        all.add(isRotationEnabled);
        all.add(scaleX);
        all.add(scaleY);
        all.add(scaleRotation);
        all.add(sensitiveScaleRotation);
        all.add(isSensitiveRotationEnabled);
    }

    @Override
    public List<Pref<?>> getAll() {
        return all;
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

    public DoublePref getSensitiveScaleRotation() {
        return sensitiveScaleRotation;
    }

    public BooleanPref isSensitiveRotationEnabled() {
        return isSensitiveRotationEnabled;
    }
}