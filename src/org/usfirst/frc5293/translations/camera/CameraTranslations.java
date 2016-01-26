package org.usfirst.frc5293.translations.camera;

import org.usfirst.frc5293.translations.util.Point;
import org.usfirst.frc5293.util.MathUtil;

public class CameraTranslations {

    private static CameraTranslations instance;

    public static CameraTranslations getInstance() {
        if (instance == null) {
            instance = new CameraTranslations();
        }

        return instance;
    }

    //

    private CameraTranslations() { }

    public Point applyInverting(Point state) {
        state.neg();
        return state;
    }

    public Point applyInputScaling(Point state) {
        state.apply(CameraTranslations::scaleInput);
        return state;
    }

    public Point applyQuadScaling(Point state) {
        state.apply(MathUtil::quadEase);
        return state;
    }

    public Point applyOutputLimit(Point state) {
        state.apply(x -> MathUtil.limit(x, 0.0, 1.0));
        return state;
    }

    /**
     * Scales the joystick input value to the servo value
     *
     * @param value  the joystick input value [-1.0..1.0]
     * @return the server input value [0.0..1.0]
     */
    public static double scaleInput(double value) {
        value = MathUtil.limit(value, -1.0, 1.0);
        return (value + 1.0) / 2.0;
    }
}
