package org.usfirst.frc5293.util.preferences;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntPref extends Pref<Integer> {
    public IntPref(String key, int defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Integer get() {
        return (int) SmartDashboard.getNumber(key, defaultValue);
    }

    @Override
    public void set(Integer value) {
        SmartDashboard.putNumber(key, value);
    }
}
