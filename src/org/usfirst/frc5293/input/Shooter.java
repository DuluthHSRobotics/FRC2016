package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Shooter {
    private static final int BUTTON = 1;

    private final Joystick joystick;
    private final JoystickButton button;

    public Shooter(Joystick joystick) {
        this.joystick = joystick;

        this.button = new JoystickButton(this.joystick, BUTTON);
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public JoystickButton getButton() {
        return button;
    }
}
