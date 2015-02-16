package org.usfirst.frc5293;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc5293.input.BinElevator;
import org.usfirst.frc5293.input.Camera;
import org.usfirst.frc5293.input.MecanumDrive;
import org.usfirst.frc5293.input.ToteElevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Input {

    private static ToteElevator toteElevator;
    private static BinElevator binElevator;
    private static MecanumDrive mecanumDrive;
    private static Camera camera;

    public static void init() {
        Joystick joystick1 = new Joystick(0);
        Joystick joystick2 = new Joystick(1);
        Joystick joystick3 = new Joystick(2);

        toteElevator = new ToteElevator(joystick3);
        binElevator = new BinElevator(joystick3);
        mecanumDrive = new MecanumDrive(joystick1, joystick2);
        camera = new Camera(joystick3);
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
}

