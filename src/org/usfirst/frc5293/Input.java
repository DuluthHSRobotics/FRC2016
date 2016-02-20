package org.usfirst.frc5293;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.input.*;
import org.usfirst.frc5293.input.util.NullJoystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Input {

    private static Drivetrain drivetrain;
    private static Camera camera;
    private static CameraRingLight cameraRingLight;
    private static Shooter shooter;
    private static ShooterKicker shooterKicker;

    private static JoystickButton sensitivityModeButton;

    public static void init() {
        Joystick joystick1 = new Joystick(0);
        Joystick joystick2 = new Joystick(1);
        Joystick joystick3 = new Joystick(2);

        drivetrain = new Drivetrain(joystick2);
        camera = new Camera(NullJoystick.getInstance());
        cameraRingLight = new CameraRingLight(joystick3);
        shooter = new Shooter(joystick3);
        shooterKicker = new ShooterKicker(joystick1);
        sensitivityModeButton = new JoystickButton(NullJoystick.getInstance(), 2);
    }

    public static Drivetrain getDrivetrain() {
        return drivetrain;
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

    public static ShooterKicker getShooterKicker() {
        return shooterKicker;
    }
}

