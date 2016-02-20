package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.OperationPipeline;

public class JoystickDrivePipeline extends OperationPipeline<DrivingState> {

    private static JoystickDrivePipeline instance;

    public static JoystickDrivePipeline getInstance() {
        if (instance == null) {
            instance = new JoystickDrivePipeline();
        }

        return instance;
    }

    //

    private JoystickDrivePipeline() {
//        ops.add(x::applySystemDisabling);
//        ops.add(x::applyAxisDisabling);
//        ops.add(x::applyAxisLocking);
//        ops.add(x::applyQuadScaling);
//        ops.add(x::applyDefaultScaling);
//        ops.add(x::applySensitiveScaling);
//        ops.add(x::applyInversions);
    }
}
