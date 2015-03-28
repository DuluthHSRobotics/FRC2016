package org.usfirst.frc5293.translations.autonomous;

import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.prefs.Drivetrain;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.InputTranslationEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MecanumDriveEngine extends InputTranslationEngine<DrivingState> {

    private static MecanumDriveEngine instance;

    public static MecanumDriveEngine getInstance() {
        if (instance == null) {
            instance = new MecanumDriveEngine();
        }
        return instance;
    }

    //

    private final Drivetrain prefs = Prefs.getDrivetrain();

    private MecanumDriveEngine() {

    }

    @Override
    protected List<Function<DrivingState, DrivingState>> getOperations() {
        List<Function<DrivingState, DrivingState>> ops = new ArrayList<>();

        ops.add(this::applySystemDisabling);

        return ops;
    }

    private DrivingState applySystemDisabling(DrivingState state) {
        if (!prefs.isSystemEnabled().get()) {
            state.x = 0;
            state.y = 0;
            state.r = 0;
        }

        return state;
    }
}
