package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public class DrivingState {
    public double power;
    public double rotation;

    public DrivingState() {
    }

    public DrivingState(double power, double rotation, double r) {
        this.power = power;
        this.rotation = rotation;
    }

    public void apply(Function<Double, Double> func) {
        power = func.apply(power);
        rotation = func.apply(rotation);
    }
}
