package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.DoublePref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public class DriveScalingPref implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();
    private final String name;

    private final BooleanPref isEnabled;
    private final DoublePref x;
    private final DoublePref y;
    private final DoublePref rotation;

    public DriveScalingPref(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "default";
        } else {
            this.name = name;
        }

        isEnabled = new BooleanPref(
                "drivetrain:scaling:" + name + ":isEnabled",
                true
        ); { all.add(isEnabled); }

        x = new DoublePref(
                "drivetrain:scaling:" + name + ":x",
                1.0
        ); { all.add(x); }

        y = new DoublePref(
                "drivetrain:scaling:" + name + ":y",
                1.0
        ); { all.add(y); }

        rotation = new DoublePref(
                "drivetrain:scaling:" + name + ":rotation",
                1.0
        ); { all.add(rotation); }
    }

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
