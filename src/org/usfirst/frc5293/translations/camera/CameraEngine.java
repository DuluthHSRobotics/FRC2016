package org.usfirst.frc5293.translations.camera;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.input.Camera;
import org.usfirst.frc5293.translations.util.Point;
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine;

public class CameraEngine extends StreamingTranslationEngine<Point> {

    private static CameraEngine instance;

    public static CameraEngine getInstance() {
        if (instance == null) {
            instance = new CameraEngine();
        }
        return instance;
    }

    //

    private final Camera input;

    private CameraEngine() {
        super(CameraPipeline.getInstance());
        input = Input.getCamera();
    }

    @Override
    protected Point getInitial() {
        Point state = new Point();

        state.x = input.getJoystick().getTwist();
        state.y = input.getJoystick().getY();

        return state;
    }

}
