package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.OperationPipeline;

public class AutonomousDrivePipeline extends OperationPipeline<DrivingState> {

    private static AutonomousDrivePipeline instance;

    public static AutonomousDrivePipeline getInstance() {
        if (instance == null) {
            instance = new AutonomousDrivePipeline();
        }

        return instance;
    }

    //

    private final DriveTranslations x = DriveTranslations.getInstance();

    private AutonomousDrivePipeline() {
        ops.add(x::applySystemDisabling);
        ops.add(x::applyInversions);
    }
}
