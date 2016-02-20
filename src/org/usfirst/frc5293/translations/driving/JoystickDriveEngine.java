package org.usfirst.frc5293.translations.driving;

import org.usfirst.frc5293.Input;
import org.usfirst.frc5293.input.DrivetrainTank;
import org.usfirst.frc5293.translations.util.StreamingTranslationEngine;
import org.usfirst.frc5293.translations.util.TankDrivingState;

public class JoystickDriveEngine extends StreamingTranslationEngine<TankDrivingState> {

    private static JoystickDriveEngine instance;

    public static JoystickDriveEngine getInstance() {
        if (instance == null) {
            instance = new JoystickDriveEngine();
        }
        return instance;
    }

    //

    private final DrivetrainTank input;

    protected JoystickDriveEngine() {
        super(JoystickDrivePipeline.getInstance());
        input = Input.INSTANCE.getDrivetrain();
    }

    @Override
    protected TankDrivingState getInitial() {
        TankDrivingState state = new TankDrivingState();

        state.left = input.getLeftJoystick().getY();
        state.right = input.getRightJoystick().getY();

        return state;
    }

}
