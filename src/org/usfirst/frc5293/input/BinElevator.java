package org.usfirst.frc5293.input;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.InlineActionCommand;

public class BinElevator {

    private static final int MAIN_EXPAND_BUTTON = 5;
    private static final int MAIN_RETRACT_BUTTON = 3;
    private static final int EXTENDER_EXPAND_BUTTON = 9;
    private static final int EXTENDER_RETRACT_BUTTON = 11;

    private final Joystick joystick;
    private final JoystickButton mainExpandButton;
    private final JoystickButton mainRetractButton;

    // TODO: We need a toggle button implementation
    private final JoystickButton extenderExpandButton;
    private final JoystickButton extenderRetractButton;

    public BinElevator(Joystick joystick) {
        this.joystick = joystick;

        mainExpandButton = new JoystickButton(this.joystick, MAIN_EXPAND_BUTTON);
        mainExpandButton.whenPressed(new InlineActionCommand(Subsystems.getBinElevator(), () ->
                Subsystems.getBinElevator().getMainExtender().extend()));

        mainRetractButton = new JoystickButton(this.joystick, MAIN_RETRACT_BUTTON);
        mainRetractButton.whenPressed(new InlineActionCommand(Subsystems.getBinElevator(), () ->
                Subsystems.getBinElevator().getMainExtender().retract()));

        extenderExpandButton = new JoystickButton(this.joystick, EXTENDER_EXPAND_BUTTON);
        extenderExpandButton.whenPressed(new InlineActionCommand(Subsystems.getBinElevator(), () ->
                Subsystems.getBinElevator().getArmExtender().extend()));

        extenderRetractButton = new JoystickButton(this.joystick, EXTENDER_RETRACT_BUTTON);
        extenderRetractButton.whenPressed(new InlineActionCommand(Subsystems.getBinElevator(), () ->
                Subsystems.getBinElevator().getArmExtender().retract()));
    }

    public Joystick getJoystick() {
        return joystick;
    }

}
