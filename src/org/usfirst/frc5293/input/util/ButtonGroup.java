package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A "psuedo-button" that wraps around a group of buttons.
 */
public abstract class ButtonGroup extends Button {
    protected final List<JoystickButton> buttons;

    protected ButtonGroup(Joystick joystick, int[] buttons) {
        final ArrayList<JoystickButton> joystickButtons = new ArrayList<>();

        for (int n : buttons) {
            joystickButtons.add(new JoystickButton(joystick, n));
        }

        this.buttons = joystickButtons;
    }

    protected ButtonGroup(JoystickButton... buttons) {
        this(Arrays.asList(buttons));
    }

    protected ButtonGroup(List<JoystickButton> buttons) {
        this.buttons = buttons;
    }
}
