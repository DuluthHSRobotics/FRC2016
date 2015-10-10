package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.DoublePref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;
import org.usfirst.frc5293.translations.util.DrivingState;

import java.util.ArrayList;
import java.util.List;

public class DriveScalingPref implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();
    private String name;

    public DriveScalingPref(String name) {
        this.name = name;

        if (this.name == null || this.name.isEmpty()) {
            this.name = "default";
        }
    }

    private final BooleanPref isEnabled = new BooleanPref(
            "drivetrain:scaling:" + name + ":isEnabled",
            true
    ); { all.add(isEnabled); }

    private final DoublePref x = new DoublePref(
            "drivetrain:scaling:" + name + ":x",
            1.0
    ); { all.add(x); }

    private final DoublePref y = new DoublePref(
            "drivetrain:scaling:" + name + ":y",
            1.0
    ); { all.add(y); }

    private final DoublePref rotation = new DoublePref(
            "drivetrain:scaling:" + name + ":rotation",
            1.0
    ); { all.add(rotation); }

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }

    public BooleanPref isEnabled() {
        return isEnabled;
    }

    public DoublePref getX() {
        return x;
    }

    public DoublePref getY() {
        return y;
    }

    public DoublePref getRotation() {
        return rotation;
    }
}
