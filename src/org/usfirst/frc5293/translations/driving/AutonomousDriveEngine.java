package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.InputTranslationEngine;

public class AutonomousDriveEngine extends InputTranslationEngine<DrivingState> {

    private static AutonomousDriveEngine instance;

    public static AutonomousDriveEngine getInstance() {
        if (instance == null) {
            instance = new AutonomousDriveEngine();
        }
        return instance;
    }

    //

    protected AutonomousDriveEngine() {
        super(AutonomousDrivePipeline.getInstance());
    }
}
