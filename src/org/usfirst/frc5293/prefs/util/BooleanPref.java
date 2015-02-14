package org.usfirst.frc5293.prefs.util;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BooleanPref extends Pref<Boolean> {
    public BooleanPref(String key, Boolean defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Boolean get() {
        return Preferences.getInstance().getBoolean(key, defaultValue);
    }

    @Override
    public void set(Boolean value) {
        Preferences.getInstance().putBoolean(key, value);
    }
}
