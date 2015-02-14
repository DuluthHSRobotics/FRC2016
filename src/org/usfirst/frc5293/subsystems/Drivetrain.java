package org.usfirst.frc5293.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5293.Devices;
import org.usfirst.frc5293.commands.MecanumDriveControl;
import org.usfirst.frc5293.util.CustomRobotDrive;

public class Drivetrain extends Subsystem {

    private final CustomRobotDrive drive = Devices.Drivetrain.getControl();

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDriveControl());
    }

    public void drive(double x, double y, double r) {
        // TODO: Just for debug right now
        SmartDashboard.putNumber("Joystick X", x);
        SmartDashboard.putNumber("Joystick Y", y);
        SmartDashboard.putNumber("Joystick Rotation", r);

        drive.mecanumDrive_Cartesian(x, y, r, 0);

        SmartDashboard.putNumber("Front Left", Devices.Drivetrain.getFrontLeft().get());
        SmartDashboard.putNumber("Front Right", Devices.Drivetrain.getFrontRight().get());
        SmartDashboard.putNumber("Back Left", Devices.Drivetrain.getBackLeft().get());
        SmartDashboard.putNumber("Back Right", Devices.Drivetrain.getBackRight().get());
    }

    public void stop() {
    	drive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
}

