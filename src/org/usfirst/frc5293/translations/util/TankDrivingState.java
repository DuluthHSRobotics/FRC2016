package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public class TankDrivingState {
    public double left;
    public double right;

    public TankDrivingState() {
    }

    public TankDrivingState(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public void apply(Function<Double, Double> func) {
        left = func.apply(left);
        right = func.apply(right);
    }
}
