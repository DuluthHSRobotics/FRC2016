package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.SingleActionCommand;

public class BinElevatorOnPressed extends SingleActionCommand {
    private static Runnable action =
            () -> Subsystems.getBinElevator().getControlCommand().reverse();

    public BinElevatorOnPressed() {
        super(action, Subsystems.getBinElevator());
    }
}
