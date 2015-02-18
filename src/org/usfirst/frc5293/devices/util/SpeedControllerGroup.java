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
        apply(x -> x.set(speed, syncGroup));
    }

    @Override
    public void set(double speed) {
        apply(x -> x.set(speed));
    }

    @Override
    public void disable() {
        apply(SpeedController::disable);
    }

    @Override
    public void pidWrite(double output) {
        apply(x -> x.pidWrite(output));
    }

    private void apply(Consumer<? super SpeedController> func) {
        controllers.stream().forEach(func);
    }
}
