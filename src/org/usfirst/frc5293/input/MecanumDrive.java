package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc5293.input.util.OrButtonGroup;

public class MecanumDrive {
    private static final int[] DRIVE_X_AXIS_BUTTONS = new int[] { 3, 2 };
    private static final int[] DRIVE_Y_AXIS_BUTTONS = new int[] { 4, 5 };

    private final Joystick strafeJoystick;
    private final Joystick rotationJoystick;
    private final Button driveXAxisButton;
    private final Button driveYAxisButton;

    public MecanumDrive(Joystick strafeJoystick, Joystick rotationJoystick) {
        this.strafeJoystick = strafeJoystick;
        this.rotationJoystick = rotationJoystick;

        driveXAxisButton = new OrButtonGroup(this.strafeJoystick, DRIVE_X_AXIS_BUTTONS);
        driveYAxisButton = new OrButtonGroup(this.strafeJoystick, DRIVE_Y_AXIS_BUTTONS);
    }

    public Joystick getStrafeJoystick() {
        return strafeJoystick;
    }

    public Joystick getRotationJoystick() {
        return rotationJoystick;
    }

    public Button getDriveXAxisButton() {
        return driveXAxisButton;
    }

    public Button getDriveYAxisButton() {
        return driveYAxisButton;
    }
}

