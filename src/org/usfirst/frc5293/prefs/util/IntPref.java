package org.usfirst.frc5293.prefs.util;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntPref extends Pref<Integer> {
    public IntPref(String key, int defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Integer get() {
        return Preferences.getInstance().getInt(key, defaultValue);
    }

    @Override
    public void set(Integer value) {
        Preferences.getInstance().putInt(key, value);
    }
}
