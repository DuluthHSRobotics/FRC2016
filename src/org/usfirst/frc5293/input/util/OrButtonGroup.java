package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.List;

/**
 * A "psuedo-button" that wraps around a group of buttons. This "pseudo-button" is considered
 * pressed when <b>any</b> of the underlying buttons are down.
 */
public class OrButtonGroup extends ButtonGroup {

    public OrButtonGroup(Joystick joystick, int[] buttons) {
        super(joystick, buttons);
    }

    public OrButtonGroup(JoystickButton... buttons) {
        super(buttons);
    }

    public OrButtonGroup(List<JoystickButton> buttons) {
        super(buttons);
    }

    @Override
    public boolean get() {
        return buttons.stream().anyMatch(JoystickButton::get);
    }

    // TODO: Do we need to override the rest of the these methods or not?
}
