package org.usfirst.frc5293.devices.util;

import edu.wpi.first.wpilibj.SpeedController;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * A pseudo speed controller that groups its underlying speed controllers. All actions on the group
 * will be propagated to the underlying speed controllers.
 */
public class SpeedControllerGroup implements SpeedController {
    private final List<SpeedController> controllers;

    private boolean isInverted = false;
    private boolean isDisabled = false;

    public SpeedControllerGroup(SpeedController... controllers) {
        this(Arrays.asList(controllers));
    }

    public SpeedControllerGroup(List<SpeedController> controllers) {
        if (controllers.size() == 0) {
            throw new IllegalArgumentException("Must contain at least 2 controllers");
        }

        this.controllers = controllers;
    }

    @Override
    public double get() {
        return controllers.get(0).get();
    }

    @Override
    public void set(double speed, byte syncGroup) {
        if (isDisabled) return;

        final double actualSpeed = getSign() * speed;
        apply(x -> x.set(actualSpeed, syncGroup));
    }

    @Override
    public void set(double speed) {
        if (isDisabled) return;

        final double actualSpeed = getSign() * speed;
        apply(x -> x.set(actualSpeed));
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
    public void pidWrite(double output) {
        apply(x -> x.pidWrite(output));
    }

    @Override
    public void disable() {
        set(0);
        this.isDisabled = true;
        apply(SpeedController::disable);
    }

    private void apply(Consumer<? super SpeedController> func) {
        controllers.stream().forEach(func);
    }

    private double getSign() {
        return isInverted ? -1 : +1;
    }
}
