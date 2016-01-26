package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.List;

/**
 * A "psuedo-button" that wraps around a group of buttons. This "pseudo-button" is considered
 * pressed <b>only</b> when <b>all</b> of the underlying buttons are pressed.
 */
public class AndButtonGroup extends ButtonGroup {

    public AndButtonGroup(Joystick joystick, int[] buttons) {
        super(joystick, buttons);
    }

    public AndButtonGroup(JoystickButton... buttons) {
        super(buttons);
    }

    public AndButtonGroup(List<JoystickButton> buttons) {
        super(buttons);
    }

    @Override
    public boolean get() {
        return buttons.stream().allMatch(JoystickButton::get);
    }
    
    // TODO: Do we need to override the rest of the these methods or not?
}
