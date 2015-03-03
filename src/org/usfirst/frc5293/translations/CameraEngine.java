package org.usfirst.frc5293.translations;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.input.Camera;
import org.usfirst.frc5293.translations.util.Point;
import org.usfirst.frc5293.translations.util.TranslationEngine;
import org.usfirst.frc5293.util.MathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CameraEngine extends TranslationEngine<Point> {
    private final Camera input;

    public CameraEngine() {
        input = Input.getCamera();
    }

    @Override
    protected List<Function<Point, Point>> getOperations() {
        List<Function<Point, Point>> ops = new ArrayList<>();

        ops.add(this::applyQuadScaling);
        ops.add(this::applyInputScaling);
        ops.add(this::applyInverting);

        return ops;
    }

    @Override
    protected Point getInitial() {
        Point state = new Point();

        state.x = input.getJoystick().getTwist();
        state.y = input.getJoystick().getY();

        return state;
    }

    private Point applyInverting(Point state) {
        state.neg();
        return state;
    }

    private Point applyInputScaling(Point state) {
        state.apply(CameraEngine::scaleInput);
        return state;
    }

    private Point applyQuadScaling(Point state) {
        state.apply(MathUtil::quad);
        return state;
    }

    /**
     * Scales the joystick input value to the servo value
     *
     * @param value  the joystick input value [-1.0..1.0]
     * @return the server input value [0.0..1.0]
     */
    private static double scaleInput(double value) {
        value = MathUtil.limit(value, -1.0, 1.0);
        return (value + 1.0) / 2.0;
    }
}
