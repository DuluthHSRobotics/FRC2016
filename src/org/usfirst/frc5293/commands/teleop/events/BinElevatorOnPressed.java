package org.usfirst.frc5293.commands.teleop.events;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ActionCommand;

public class BinElevatorOnPressed extends ActionCommand {
    public BinElevatorOnPressed() {
        super(Subsystems.getBinElevator());
    }

    @Override
    protected void action() {
        Subsystems.getBinElevator().getMainExtender().reverse();
    }
}
