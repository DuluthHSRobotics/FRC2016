package org.usfirst.frc5293.util.preferences;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DoublePref extends Pref<Double> {
    public DoublePref(String key, Double defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Double get() {
        return SmartDashboard.getNumber(key, defaultValue);
    }

    @Override
    public void set(Double value) {
        SmartDashboard.putNumber(key, value);
    }
}
