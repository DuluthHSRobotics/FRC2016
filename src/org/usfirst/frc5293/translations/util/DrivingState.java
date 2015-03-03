package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public class DrivingState {
    public double x;
    public double y;
    public double r;

    public void apply(Function<Double, Double> func) {
        x = func.apply(x);
        y = func.apply(y);
        r = func.apply(r);
    }
}
