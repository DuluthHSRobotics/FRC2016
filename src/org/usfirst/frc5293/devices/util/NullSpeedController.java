package org.usfirst.frc5293.devices.util;

import edu.wpi.first.wpilibj.SpeedController;

public final class NullSpeedController implements SpeedController {

    private NullSpeedController() {
    }

    public static final NullSpeedController INSTANCE = new NullSpeedController();

    @Override
    public double get() {
        return 0;
    }

    @Override
    public void set(double speed, byte syncGroup) {
    }

    @Override
    public void set(double speed) {
    }

    @Override
    public void disable() {
    }

    @Override
    public void pidWrite(double output) {
    }
}
