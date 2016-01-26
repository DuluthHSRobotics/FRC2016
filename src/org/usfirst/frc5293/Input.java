package org.usfirst.frc5293;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.input.*;
import org.usfirst.frc5293.input.util.NullJoystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Input {

    private static ToteElevator toteElevator;
    private static BinElevator binElevator;
    private static MecanumDrive mecanumDrive;
    private static Camera camera;
    private static Shooter shooter;

    private static JoystickButton sensitivityModeButton;

    public static void init() {
        Joystick joystick1 = new Joystick(0);
        Joystick joystick2 = new Joystick(1);
        Joystick joystick3 = new Joystick(2);

        toteElevator = new ToteElevator(NullJoystick.INSTANCE);
        binElevator = new BinElevator(NullJoystick.INSTANCE);
        mecanumDrive = new MecanumDrive(NullJoystick.INSTANCE, NullJoystick.INSTANCE);
        camera = new Camera(NullJoystick.INSTANCE);
        shooter = new Shooter(joystick3);

        sensitivityModeButton = new JoystickButton(NullJoystick.INSTANCE, 2);
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

    public static Camera getCamera() {
        return camera;
    }

    public static Shooter getShooter() {
        return shooter;
    }

    public static JoystickButton getSensitivityModeButton() {
        return sensitivityModeButton;
    }
}

