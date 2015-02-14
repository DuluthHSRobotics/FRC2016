package org.usfirst.frc5293.prefs.util;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DoublePref extends Pref<Double> {
    public DoublePref(String key, Double defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Double get() {
        return Preferences.getInstance().getDouble(key, defaultValue);
    }

    @Override
    public void set(Double value) {
        Preferences.getInstance().putDouble(key, value);
    }
}
