package org.usfirst.frc5293;
    
import org.usfirst.frc5293.devices.*;

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class Devices {

    private static Drivetrain drivetrain;
    private static Camera camera;
    private static CameraRingLight cameraRingLight;

    private static Shooter shooter;
    private static Lifter lifter;

    public static void init() {
        drivetrain = new Drivetrain();
        camera = new Camera();
        cameraRingLight = new CameraRingLight();
        shooter = new Shooter();
        lifter = new Lifter();
    }

    public static Drivetrain getDrivetrain() {
        return drivetrain;
    }

    public static Camera getCamera() {
        return camera;
    }

    public static CameraRingLight getCameraRingLight() { return cameraRingLight; }

    public static Shooter getShooter() {
        return shooter;
    }

    public static Lifter getLifter() {
        return lifter;
    }
}
