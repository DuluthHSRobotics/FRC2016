package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc5293.util.input.UpDownInput;

public class ToteElevator extends UpDownInput {
    private static final int UP_BUTTON = 6;
    private static final int DOWN_BUTTON = 4;
    private final Joystick joystick;

    public ToteElevator(Joystick joystick) {
        super(joystick, UP_BUTTON, DOWN_BUTTON);
        this.joystick = joystick;
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
