package org.usfirst.frc5293.input.util;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.Arrays;
import java.util.List;

/**
 * A "psuedo-button" that wraps around a group of buttons. This "pseudo-button" is considered down
 * when <b>any</b> of the underlying buttons are down.
 */
public class OrButtonGroup extends Button {
    private final List<JoystickButton> buttons;

    public OrButtonGroup(JoystickButton... buttons) {
        this(Arrays.asList(buttons));
    }

    public OrButtonGroup(List<JoystickButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public boolean get() {
        return buttons.stream().anyMatch(JoystickButton::get);
    }

    // TODO: Do we need to override the rest of the these methods or not?
}
