package org.usfirst.frc5293;

import org.usfirst.frc5293.subsystems.*;

public class Subsystems {
    private static Drivetrain drivetrain;
    private static Camera camera;
    private static CameraRingLight cameraRingLight;
    private static Shooter shooter;

    public static void init() {
        drivetrain = new Drivetrain();
        camera = new Camera();
        cameraRingLight = new CameraRingLight();
        shooter = new Shooter();
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
}
