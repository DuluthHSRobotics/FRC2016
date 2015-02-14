package org.usfirst.frc5293;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.autoncommands.AutonDrive;
import org.usfirst.frc5293.commands.AutonomousCommand;
import org.usfirst.frc5293.commands.BinElevatorOnPressed;
import org.usfirst.frc5293.commands.MecanumDriveControl;
import org.usfirst.frc5293.commands.ToteElevatorControl;
import org.usfirst.frc5293.util.input.UpDownInput;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Input {
    private static Joystick joystick1;
    private static Joystick joystick2;
    private static Joystick joystick3;

    public static class ToteElevator extends UpDownInput {
        private static final int UP_BUTTON = 5;
        private static final int DOWN_BUTTON = 3;

        public ToteElevator() {
            super(joystick3, UP_BUTTON, DOWN_BUTTON);
        }
    }

    public static class BinElevator {
        private static final int BUTTON = 9;

        private final JoystickButton toggleButton;

        public BinElevator() {
            toggleButton = new JoystickButton(joystick1, BUTTON);
            toggleButton.whenPressed(new BinElevatorOnPressed());
        }

        public JoystickButton getToggleButton() {
            return toggleButton;
        }
    }

    private static ToteElevator toteElevator;
    private static BinElevator binElevator;

    public static void init() {
        joystick1 = new Joystick(0);
        joystick2 = new Joystick(1);
        joystick3 = new Joystick(3);

        toteElevator = new ToteElevator();
        binElevator = new BinElevator();

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Collect Tote", new ToteElevatorControl());

        SmartDashboard.putData("Mecanum Drive", new MecanumDriveControl());

        SmartDashboard.putData("Auton Drive", new AutonDrive());
    }

    public static Joystick getJoystick1() {
        return joystick1;
    }

    public static Joystick getJoystick2() {
        return joystick2;
    }

    public static ToteElevator getToteElevator() {
        return toteElevator;
    }

    public static BinElevator getBinElevator() {
        return binElevator;
    }
}

