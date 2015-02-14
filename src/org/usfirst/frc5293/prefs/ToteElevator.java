package org.usfirst.frc5293.prefs;

import org.usfirst.frc5293.prefs.util.BooleanPref;
import org.usfirst.frc5293.prefs.util.DoublePref;
import org.usfirst.frc5293.prefs.util.Pref;
import org.usfirst.frc5293.prefs.util.PrefGroup;

import java.util.ArrayList;
import java.util.List;

public class ToteElevator implements PrefGroup {
    private final List<Pref<?>> all = new ArrayList<>();

    private final DoublePref speed = new DoublePref(
            "tote_elevator:speed",
            0.5
    );

    private final DoublePref voltageRamp = new DoublePref(
            "tote_elevator:voltage_ramp",
            24.0
    );

    private final BooleanPref isVoltageRampEnabled = new BooleanPref(
            "tote_elevator:is_voltage_ramp_enabled",
            true
    );

    public ToteElevator() {
        all.add(speed);
        all.add(voltageRamp);
        all.add(isVoltageRampEnabled);
    }

    @Override
    public List<Pref<?>> getAll() {
        return all;
    }

    public DoublePref getSpeed() {
        return speed;
    }

    public DoublePref getVoltageRamp() {
        return voltageRamp;
    }

    public BooleanPref getIsVoltageRampEnabled() {
        return isVoltageRampEnabled;
    }
}
