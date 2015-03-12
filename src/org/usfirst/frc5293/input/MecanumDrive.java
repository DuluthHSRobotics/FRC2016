package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class MecanumDrive {
    private static final int SENSITIVE_ROTATION_BUTTON = 2;
    private static final int DRIVE_X_AXIS_BUTTON = 4;
    private static final int DRIVE_Y_AXIS_BUTTON = 2;

    private final Joystick strafeJoystick;
    private final Joystick rotationJoystick;
    private final JoystickButton driveXAxisButton;
    private final JoystickButton driveYAxisButton;

    public MecanumDrive(Joystick strafeJoystick, Joystick rotationJoystick) {
        this.strafeJoystick = strafeJoystick;
        this.rotationJoystick = rotationJoystick;

        driveXAxisButton = new JoystickButton(this.strafeJoystick, DRIVE_X_AXIS_BUTTON);
        driveYAxisButton = new JoystickButton(this.strafeJoystick, DRIVE_Y_AXIS_BUTTON);
    }

    public Joystick getStrafeJoystick() {
        return strafeJoystick;
    }

    public Joystick getRotationJoystick() {
        return rotationJoystick;
    }

    public JoystickButton getDriveXAxisButton() {
        return driveXAxisButton;
    }

    public JoystickButton getDriveYAxisButton() {
        return driveYAxisButton;
    }
}

