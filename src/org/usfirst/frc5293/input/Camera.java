package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;

public class Camera {
    private final Joystick joystick;

    public Camera(Joystick joystick) {
        this.joystick = joystick;
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
