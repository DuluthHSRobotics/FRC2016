package org.usfirst.frc5293;

import org.usfirst.frc5293.subsystems.BinElevator;
import org.usfirst.frc5293.subsystems.Camera;
import org.usfirst.frc5293.subsystems.Drivetrain;
import org.usfirst.frc5293.subsystems.ToteElevator;

public class Subsystems {
    private static Drivetrain drivetrain;
    private static ToteElevator toteElevator;
    private static BinElevator binElevator;
    private static Camera camera;

    public static void init() {
        drivetrain = new Drivetrain();
        toteElevator = new ToteElevator();
        binElevator = new BinElevator();
        camera = new Camera();
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
}
