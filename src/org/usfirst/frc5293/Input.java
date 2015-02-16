package org.usfirst.frc5293;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.commands.BinElevatorOnPressed;
import org.usfirst.frc5293.util.input.UpDownInput;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Input {

    public static class ToteElevator extends UpDownInput {
        private static final int UP_BUTTON = 6;
        private static final int DOWN_BUTTON = 4;
        private final Joystick joystick;

        public ToteElevator(Joystick joystick) {
            super(joystick, UP_BUTTON, DOWN_BUTTON);
            this.joystick = joystick;
        }

        public Joystick getJoystick() {
            return joystick;
        }
    }

    public static class BinElevator {
        private static final int BUTTON = 9;

        private final JoystickButton toggleButton;
        private final Joystick joystick;

        public BinElevator(Joystick joystick) {
            this.joystick = joystick;

            toggleButton = new JoystickButton(this.joystick, BUTTON);
            toggleButton.whenPressed(new BinElevatorOnPressed());
        }

        public Joystick getJoystick() {
            return joystick;
        }

        public JoystickButton getToggleButton() {
            return toggleButton;
        }
    }

    public static class MecanumDrive {
        private static final int SENSITIVE_ROTATION_BUTTON = 2;
        private static final int DRIVE_X_AXIS_BUTTON = 4;
        private static final int DRIVE_Y_AXIS_BUTTON = 2;

        private final Joystick strafeJoystick;
        private final Joystick rotationJoystick;
        private final JoystickButton sensitiveRotationButton;
        private final JoystickButton driveXAxisButton;
        private final JoystickButton driveYAxisButton;

        public MecanumDrive(Joystick strafeJoystick, Joystick rotationJoystick) {
            this.strafeJoystick = strafeJoystick;
            this.rotationJoystick = rotationJoystick;

            sensitiveRotationButton = new JoystickButton(this.rotationJoystick, SENSITIVE_ROTATION_BUTTON);
            driveXAxisButton = new JoystickButton(this.strafeJoystick, DRIVE_X_AXIS_BUTTON);
            driveYAxisButton = new JoystickButton(this.strafeJoystick, DRIVE_Y_AXIS_BUTTON);
        }

        public Joystick getStrafeJoystick() {
            return strafeJoystick;
        }

        public Joystick getRotationJoystick() {
            return rotationJoystick;
        }

        public JoystickButton getSensitiveRotationButton() {
            return sensitiveRotationButton;
        }

        public JoystickButton getDriveXAxisButton() {
            return driveXAxisButton;
        }

        public JoystickButton getDriveYAxisButton() {
            return driveYAxisButton;
        }
    }

    private static ToteElevator toteElevator;
    private static BinElevator binElevator;
    private static MecanumDrive mecanumDrive;

    public static void init() {
        Joystick joystick1 = new Joystick(0);
        Joystick joystick2 = new Joystick(1);
        Joystick joystick3 = new Joystick(2);

        toteElevator = new ToteElevator(joystick3);
        binElevator = new BinElevator(joystick3);
        mecanumDrive = new MecanumDrive(joystick1, joystick2);
    }

    public static ToteElevator getToteElevator() {
        return toteElevator;
    }

    public static BinElevator getBinElevator() {
        return binElevator;
    }

    public static MecanumDrive getMecanumDrive() {
        return mecanumDrive;
    }
}

