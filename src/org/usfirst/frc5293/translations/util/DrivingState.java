package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public class DrivingState {
    public double x;
    public double y;
    public double r;

    public DrivingState() {
    }

    public DrivingState(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void apply(Function<Double, Double> func) {
        x = func.apply(x);
        y = func.apply(y);
        r = func.apply(r);
    }
}
