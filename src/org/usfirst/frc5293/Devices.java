package org.usfirst.frc5293;
    
import org.usfirst.frc5293.devices.*;

/**
 * The Devices is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Devices {

    private static Drivetrain drivetrain;
    private static ToteElevator toteElevator;
    private static BinElevator binElevator;
    private static Camera camera;
    private static CameraRingLight cameraRingLight;

    private static Shooter shooter;

    public static void init() {
        drivetrain = new Drivetrain();

        // TODO: Please get me some configurable IoC or something please
        toteElevator = new ToteElevatorCompetition();

        binElevator = new BinElevator();
        camera = new Camera();
        cameraRingLight = new CameraRingLight();

        shooter = new Shooter();
    }

    public static Drivetrain getDrivetrain() {
        return drivetrain;
    }

    public static ToteElevator getToteElevator() {
        return toteElevator;
    }

    public static BinElevator getBinElevator() {
        return binElevator;
    }

    public static Camera getCamera() {
        return camera;
    }

    public static CameraRingLight getCameraRingLight() { return cameraRingLight; }

    public static Shooter getShooter() {
        return shooter;
    }
}
