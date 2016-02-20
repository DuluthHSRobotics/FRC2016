package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.input.Drivetrain;
import org.usfirst.frc5293.translations.util.DrivingState;
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine;

public class JoystickDriveEngine extends StreamingTranslationEngine<DrivingState> {

    private static JoystickDriveEngine instance;

    public static JoystickDriveEngine getInstance() {
        if (instance == null) {
            instance = new JoystickDriveEngine();
        }
        return instance;
    }

    //

    private final Drivetrain input;
    private final org.usfirst.frc5293.prefs.Drivetrain prefs = Prefs.getDrivetrain();

    protected JoystickDriveEngine() {
        super(JoystickDrivePipeline.getInstance());
        input = Input.getDrivetrain();
    }

    @Override
    protected DrivingState getInitial() {
        DrivingState state = new DrivingState();

        state.power = input.getJoystick().getY();
        state.rotation = input.getJoystick().getTwist();

        return state;
    }

}
