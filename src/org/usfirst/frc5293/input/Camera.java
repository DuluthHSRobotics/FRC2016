package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.commands.teleop.events.CameraSetOriginOnPressed;

public class Camera {
    private final Joystick joystick;
    private final JoystickButton originButton;

    public Camera(Joystick joystick) {
        this.joystick = joystick;

        this.originButton = new JoystickButton(this.joystick, 1 /* Trigger */);
        this.originButton.whenActive(new CameraSetOriginOnPressed());
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
