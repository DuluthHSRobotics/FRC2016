package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.Devices;

public class Lifter extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand();
    }

    public void setPower(double power) {
        Devices.getLifter().getMotor().set(power);
    }
}