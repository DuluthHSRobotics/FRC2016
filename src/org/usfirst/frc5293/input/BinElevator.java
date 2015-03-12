package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.InlineActionCommand;

public class BinElevator {

    private final Joystick joystick;
    private final JoystickButton expandButton;
    private final JoystickButton retractButton;

    public BinElevator(Joystick joystick) {
        this.joystick = joystick;

        expandButton = new JoystickButton(this.joystick, 5);
        expandButton.whenPressed(new InlineActionCommand(Subsystems.getBinElevator(), () ->
                Subsystems.getBinElevator().extend()));

        retractButton = new JoystickButton(this.joystick, 3);
        retractButton.whenPressed(new InlineActionCommand(Subsystems.getBinElevator(), () ->
                Subsystems.getBinElevator().retract()));
    }

    public Joystick getJoystick() {
        return joystick;
    }

}
