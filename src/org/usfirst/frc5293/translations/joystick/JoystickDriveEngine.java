package org.usfirst.frc5293.translations.joystick;

import org.usfirst.frc5293.translations.MecanumDriveEngine;
import org.usfirst.frc5293.translations.util.DrivingState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class JoystickDriveEngine extends MecanumDriveEngine {

    @Override
    protected List<Function<DrivingState, DrivingState>> getOperations() {
        List<Function<DrivingState, DrivingState>> ops = new ArrayList<>();

        ops.add(this::applySystemDisabling);
        ops.add(this::applyAxisDisabling);
        ops.add(this::applyAxisLocking);
        ops.add(this::applyQuadScaling);
        ops.add(this::applySensitiveScaling);
        ops.add(this::applyInversions);

        return ops;
    }
}
