package org.usfirst.frc5293.commands.teleop.control;

import org.usfirst.frc5293.Subsystems;
import org.usfirst.frc5293.commands.util.ContinuousCommand;

public class BinElevatorControl extends ContinuousCommand {

    public BinElevatorControl() {
        requires(Subsystems.getBinElevator());
    }

    @Override
    protected void execute() {
        super.execute();
    }
}
