package org.usfirst.frc5293.translations.camera;

import org.usfirst.frc5293.translations.util.OperationPipeline;
import org.usfirst.frc5293.translations.util.Point;

public class CameraPipeline extends OperationPipeline<Point> {

    private static CameraPipeline instance;

    public static CameraPipeline getInstance() {
        if (instance == null) {
            instance = new CameraPipeline();
        }

        return instance;
    }

    //

    private final CameraTranslations x = CameraTranslations.getInstance();

    private CameraPipeline() {
        ops.add(x::applyInverting);
        ops.add(x::applyQuadScaling);
        ops.add(x::applyInputScaling);
        ops.add(x::applyOutputLimit);
    }
}
