package org.usfirst.frc5293.util.preferences;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BooleanPref extends Pref<Boolean> {
    public BooleanPref(String key, Boolean defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Boolean get() {
        return SmartDashboard.getBoolean(key, defaultValue);
    }

    @Override
    public void set(Boolean value) {
        SmartDashboard.putBoolean(key, value);
    }
}
