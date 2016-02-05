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

    private static MecanumDrive mecanumDrive;
    private static Camera camera;
    private static CameraRingLight cameraRingLight;
    private static Shooter shooter;

    private static JoystickButton sensitivityModeButton;

    public static void init() {
        Joystick joystick1 = new Joystick(0);
        Joystick joystick2 = new Joystick(1);
        Joystick joystick3 = new Joystick(2);

        mecanumDrive = new MecanumDrive(NullJoystick.getInstance(), NullJoystick.getInstance());
        camera = new Camera(joystick2);
        cameraRingLight = new CameraRingLight(joystick3);
        shooter = new Shooter(joystick3);

        sensitivityModeButton = new JoystickButton(NullJoystick.getInstance(), 2);
    }

    public static MecanumDrive getMecanumDrive() {
        return mecanumDrive;
    }

    public static Camera getCamera() {
        return camera;
    }

    public static CameraRingLight getCameraRingLight() {
        return cameraRingLight;
    }

    public static Shooter getShooter() {
        return shooter;
    }

    public static JoystickButton getSensitivityModeButton() {
        return sensitivityModeButton;
    }
}

