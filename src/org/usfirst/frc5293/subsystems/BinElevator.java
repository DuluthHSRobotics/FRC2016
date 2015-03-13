package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.commands.teleop.control.BinElevatorControl;
import org.usfirst.frc5293.subsystems.binelevator.ArmExtender;
import org.usfirst.frc5293.subsystems.binelevator.MainExtender;

public class BinElevator extends Subsystem {

    private final MainExtender mainExtender = new MainExtender();
    private final ArmExtender armExtender = new ArmExtender();

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new BinElevatorControl());
    }

    public MainExtender getMainExtender() {
        return mainExtender;
    }

    public ArmExtender getArmExtender() {
        return armExtender;
    }
}
