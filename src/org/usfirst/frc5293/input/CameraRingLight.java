package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ActionCommand;

public class CameraRingLight {
    private Joystick joystick;
    private JoystickButton button;

    public CameraRingLight(Joystick joystick) {
        this.joystick = joystick;

        this.button = new JoystickButton(joystick, 11);

        this.button.whenPressed(new ActionCommand(Subsystems.getCameraRingLight()) {
            @Override
            protected void action() {
                Subsystems.getCameraRingLight().swap();
            }
        });
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public JoystickButton getButton() {
        return button;
    }
}
