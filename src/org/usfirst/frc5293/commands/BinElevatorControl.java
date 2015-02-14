package org.usfirst.frc5293.commands;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;
import org.usfirst.frc5293.commands.util.EmptyCommand;
import org.usfirst.frc5293.subsystems.BinElevator;

public class BinElevatorControl extends ContinuousCommand {

    public BinElevatorControl() {
        requires(Subsystems.getBinElevator());
    }

    public void reverse() {
        if (!isExtended()) {
            Subsystems.getBinElevator().extend();
        } else {
            Subsystems.getBinElevator().retract();
        }
    }

    private boolean isExtended() {
        return Subsystems.getBinElevator().getState().equals(BinElevator.State.EXTEND);
    }
}
