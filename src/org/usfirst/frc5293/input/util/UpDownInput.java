package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public abstract class UpDownInput {

    private static JoystickButton upButton;
    private static JoystickButton downButton;

    public UpDownInput(Joystick joystick, int upButtonNumber, int downButtonNumber) {
        upButton = new JoystickButton(joystick, upButtonNumber);
        downButton = new JoystickButton(joystick, downButtonNumber);
    }

    public JoystickButton getUpButton() {
        return upButton;
    }

    public JoystickButton getDownButton() {
        return downButton;
    }
}
