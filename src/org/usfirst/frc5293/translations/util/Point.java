package org.usfirst.frc5293.translations.util;

import java.util.function.Function;

public class Point {
    public double x;
    public double y;

    public void apply(Function<Double, Double> func) {
        x = func.apply(x);
        y = func.apply(y);
    }

    public void neg() {
        x *= -1;
        y *= -1;
    }
}
