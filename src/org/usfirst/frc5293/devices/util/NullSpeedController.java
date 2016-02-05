package org.usfirst.frc5293.devices.util;

import edu.wpi.first.wpilibj.SpeedController;

public final class NullSpeedController implements SpeedController {

    private static NullSpeedController instance;

    public static NullSpeedController getInstance() {
        if (instance == null) {
            instance = new NullSpeedController();
        }

        return instance;
    }

    //

    private boolean isInverted = false;

    private NullSpeedController() {
    }

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
    public void setInverted(boolean isInverted) {
        this.isInverted = isInverted;
    }

    @Override
    public boolean getInverted() {
        return this.isInverted;
    }

    @Override
    public void disable() {
    }

    @Override
    public void pidWrite(double output) {
    }
}
