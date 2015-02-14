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

    public Drivetrain() {
        all.add(isXEnabled);
        all.add(isYEnabled);
        all.add(isRotationEnabled);
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
}
