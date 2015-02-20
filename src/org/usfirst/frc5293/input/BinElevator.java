package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.commands.teleop.events.BinElevatorOnPressed;

public class BinElevator {
    private static final int BUTTON = 9;

    private final JoystickButton toggleButton;
    private final Joystick joystick;

    public BinElevator(Joystick joystick) {
        this.joystick = joystick;

        toggleButton = new JoystickButton(this.joystick, BUTTON);
        toggleButton.whenPressed(new BinElevatorOnPressed());
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public JoystickButton getToggleButton() {
        return toggleButton;
    }
}
