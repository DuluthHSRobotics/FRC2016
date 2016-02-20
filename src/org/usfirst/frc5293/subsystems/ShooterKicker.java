package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.teleop.control.ShooterKickerControl;

public class ShooterKicker extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterKickerControl());
    }

    public void set(double x) {
        SmartDashboard.putNumber("Shooter Kicker", x);
        Devices.getShooterKicker().getKicker().set(x);
    }

    public void setAngle(double angle) {
        SmartDashboard.putNumber("Shooter Kicker Angle", angle);
        Devices.getShooterKicker().getKicker().setAngle(angle);
    }
}
