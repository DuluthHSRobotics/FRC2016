package org.usfirst.frc5293.devices;

import edu.wpi.first.wpilibj.Servo;

public final class Camera {
    private final Servo sideServo;
    private final Servo topServo;

    public Camera() {
        sideServo = new Servo(5);
        topServo = new Servo(4);
    }

    public Servo getSideServo() {
        return sideServo;
    }

    public Servo getTopServo() {
        return topServo;
    }
}
