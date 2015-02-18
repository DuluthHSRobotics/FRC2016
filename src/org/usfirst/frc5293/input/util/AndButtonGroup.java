package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.Arrays;
import java.util.List;

/**
 * A "psuedo-button" that wraps around a group of buttons. This "pseudo-button" is considered down
 * when <b>all</b> of the underlying buttons are pressed.
 */
public class AndButtonGroup extends Button {
    private final List<JoystickButton> buttons;

    public AndButtonGroup(JoystickButton... buttons) {
        this(Arrays.asList(buttons));
    }

    public AndButtonGroup(List<JoystickButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public boolean get() {
        return buttons.stream().allMatch(JoystickButton::get);
    }
    
    // TODO: Do we need to override the rest of the these methods or not?
}
