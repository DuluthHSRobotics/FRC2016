package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc5293.input.util.OrButtonGroup;

public class DrivetrainArcade {
    private static final int[] DRIVE_X_AXIS_BUTTONS = new int[] { 3, 2 };
    private static final int[] DRIVE_Y_AXIS_BUTTONS = new int[] { 4, 5 };

    private final Joystick joystick;
    private final Button driveXAxisButton;
    private final Button driveYAxisButton;

    public DrivetrainArcade(Joystick joystick) {
        this.joystick = joystick;

        driveXAxisButton = new OrButtonGroup(this.joystick, DRIVE_X_AXIS_BUTTONS);
        driveYAxisButton = new OrButtonGroup(this.joystick, DRIVE_Y_AXIS_BUTTONS);
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public Button getDriveXAxisButton() {
        return driveXAxisButton;
    }

    public Button getDriveYAxisButton() {
        return driveYAxisButton;
    }
}

