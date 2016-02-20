package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.commands.teleop.events.ShooterKickerTryStart;

public class ShooterKicker {
    private final Joystick joystick;
    private final JoystickButton kick;

    public ShooterKicker(Joystick joystick) {
        this.joystick = joystick;

        kick = new JoystickButton(this.joystick, 7);
        kick.whenPressed(new ShooterKickerTryStart());
    }

    public Joystick getJoystick() {
        return joystick;
    }
}
