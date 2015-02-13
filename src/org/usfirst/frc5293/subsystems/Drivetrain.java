package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.MecanumDriveControl;

public class Drivetrain extends Subsystem {

    private final RobotDrive drive = Devices.Drivetrain.getControl();

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDriveControl());
    }

    public void drive(double x, double y, double r) {
        drive.mecanumDrive_Cartesian(x, y, r, 0);
    }

    public void stop() {
    	drive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
}

