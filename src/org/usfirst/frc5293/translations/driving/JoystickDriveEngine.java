package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.Prefs;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.prefs.Drivetrain;
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

    private final MecanumDrive input;
    private final Drivetrain prefs = Prefs.getDrivetrain();

    protected JoystickDriveEngine() {
        super(JoystickDrivePipeline.getInstance());
        input = Input.getMecanumDrive();
    }

    @Override
    protected DrivingState getInitial() {
        DrivingState state = new DrivingState();

        state.x = input.getStrafeJoystick().getX();
        state.y = input.getStrafeJoystick().getY();
        state.r = input.getRotationJoystick().getTwist() * 0.3; // TODO: HACK!!!

        return state;
    }

}
