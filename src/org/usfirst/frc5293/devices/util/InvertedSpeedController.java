package org.usfirst.frc5293.devices.util;

import edu.wpi.first.wpilibj.SpeedController;

public final class InvertedSpeedController implements SpeedController {

    private SpeedController child;

    public InvertedSpeedController(SpeedController child) {
        this.child = child;
    }

    @Override
    public double get() {
        return -child.get();
    }

    @Override
    public void set(double speed, byte syncGroup) {
        child.set(-speed, syncGroup);
    }

    @Override
    public void set(double speed) {
        child.set(-speed);
    }

    @Override
    public void disable() {
        child.disable();
    }

    @Override
    public void pidWrite(double output) {
        child.pidWrite(-output);
    }
}
